package com.springapp.mvc.service;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.springapp.mvc.dao.*;
import com.springapp.mvc.database.*;
import com.springapp.mvc.database.dto.CellDTO;
import com.springapp.mvc.database.dto.CellFullDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.*;

import static com.itextpdf.text.Element.ALIGN_CENTER;
import static com.itextpdf.text.Font.BOLD;
import static com.itextpdf.text.html.HtmlTags.FONT;
import static com.itextpdf.text.pdf.BaseFont.TIMES_ROMAN;

@Service
@Transactional
public class CellService {
    private CellDAO cellDAO;
    private LecturerDAO lecturerDAO;
    private SubjectDAO subjectDAO;
    private GroupDAO groupDAO;
    private DayDAO dayDAO;
    private PairDAO pairDAO;

    public CellService(CellDAO cellDAO, LecturerDAO lecturerDAO, SubjectDAO subjectDAO, GroupDAO groupDAO, DayDAO dayDAO, PairDAO pairDAO) {
        this.cellDAO = cellDAO;
        this.lecturerDAO = lecturerDAO;
        this.subjectDAO = subjectDAO;
        this.groupDAO = groupDAO;
        this.dayDAO = dayDAO;
        this.pairDAO = pairDAO;
    }

    public List<CellDTO> getCellsWithoutDay() {
        List<Cell> cellList = cellDAO.getCellsWithoutDay();
        List<CellDTO> cellDTOList = new ArrayList<>();
        for (Cell c : cellList) {
            Lecturer lecturer = c.getLecturer();
            Subject subject = c.getSubject();
            Set<Group> groupSet = c.getGroupSet();
            String groups = "";
            for (Group g : groupSet) {
                groups += g.getName() + " ";
            }
            cellDTOList.add(new CellDTO(c.getId(), lecturer.getName() + " " + lecturer.getSurname(), subject.getName(), groups));
        }
        return cellDTOList;
    }

    public List<CellFullDTO> getCells() {
        List<Cell> cellList = cellDAO.getFilledCells();
        List<CellFullDTO> cellFullDTOList = convertCellToFullDTO(cellList);
        return cellFullDTOList;
    }

    public CellFullDTO getCellById(int id) {
        Cell cell = cellDAO.getCellById(id);
        CellFullDTO cellFullDTO = convertCellToFullDTO(Arrays.asList(cell)).get(0);
        return cellFullDTO;
    }

    public List<CellFullDTO> getCellsWithLecturer(int idLecturer) {
        List<Cell> cellList = cellDAO.getCellsWithLecturer(idLecturer);
        List<CellFullDTO> cellFullDTOList = convertCellToFullDTO(cellList);
        return cellFullDTOList;
    }

    public List<CellFullDTO> getCellsWithGroup(int idGroup) {
        List<Cell> cellList = cellDAO.getCellsWithGroup(idGroup);
        List<CellFullDTO> cellFullDTOList = convertCellToFullDTO(cellList);
        return cellFullDTOList;
    }

    public void addCell(int idLecturer, int idSubject, String idGroups, String type) {
        Cell cell = new Cell();
        Set<Group> groupSet = new HashSet<>();
        cell.setLecturer(lecturerDAO.getLectureById(idLecturer));
        cell.setSubject(subjectDAO.getSubjectById(idSubject));
        cell.setType(type);
        String groups[] = idGroups.split(",");
        for (String g : groups) {
            groupSet.add(groupDAO.getGroupById(new Integer(g)));
        }
        cell.setGroupSet(groupSet);
        cell.setParity("0");
        cellDAO.addCell(cell);
    }

    public void updateCell(int id, Cell cell) {
        cellDAO.updateCell(id, cell);
    }

    public void updateFullCell(int idCell, int idLecturer, int idSubject, String type, String parity, int idCabinet) {
        cellDAO.updateFullCell(idCell, idLecturer, idSubject, type, parity, idCabinet);
    }

    public void deleteCell(int id) {
        cellDAO.deleteCell(id);
    }

    public void updateDayAndPair(int idCell, int idDay, int idPair) {
        cellDAO.updateDayAndPairOfCell(idCell, idDay, idPair);
    }

    public void removeDayAndPair(int idCell) {
        cellDAO.removeDayAndPairOfCell(idCell);
    }

    private List<CellFullDTO> convertCellToFullDTO(List<Cell> cellList) {
        List<CellFullDTO> cellFullDTOList = new ArrayList<>();
        for (Cell c : cellList) {
            boolean status = true;
            Lecturer lecturer = c.getLecturer();
            Subject subject = c.getSubject();
            Cabinet cabinet = c.getCabinet();
            Set<Group> groupSet = c.getGroupSet();
            String groups = "";
            for (Group g : groupSet) {
                groups += g.getName() + " ";
            }
            CellFullDTO cellFullDTO = new CellFullDTO(c.getId(), lecturer.getSurname() + " " + lecturer.getName(), subject.getAbbreviation(), groups);
            cellFullDTO.setDay(c.getDay().getId());
            cellFullDTO.setPair(c.getPair().getId());
            cellFullDTO.setType(c.getType());
            cellFullDTO.setParity(c.getParity());
            if (cabinet != null) {
                cellFullDTO.setCabinet(cabinet.getNumber() + "/" + cabinet.getBlock());
            } else {
                cellFullDTO.setCabinet(null);
            }

            cellFullDTO.setComment("");
            if (cellDAO.getCellByLecturerAndPair(lecturer.getId(), c.getDay().getId(), c.getPair().getId(), c.getParity()) != 1) {
                status = false;
                cellFullDTO.setComment(cellFullDTO.getComment() + "Преподаватель " + lecturer.getSurname() + " " + lecturer.getName() + " уже имеет пару в это время.<br />");
            }
            if (cabinet != null) {
                if (cellDAO.getCellByCabinetAndPair(cabinet.getId(), c.getDay().getId(), c.getPair().getId(), c.getParity()) != 1) {
                    status = false;
                    cellFullDTO.setComment(cellFullDTO.getComment() + "Кабинет " + cabinet.getNumber() + "/" + cabinet.getBlock() + " уже занят в это время.<br />");
                }
            }
            for (Group group : groupSet) {
                if (cellDAO.getCellByGroupAndPair(group.getId(), c.getDay().getId(), c.getPair().getId(), c.getParity()) != 1) {
                    status = false;
                    cellFullDTO.setComment(cellFullDTO.getComment() + "Группа " + group.getName() + " уже имеет пару в это время.");
                }
            }
            if (status) {
                cellFullDTO.setStatus("ok");
                cellFullDTO.setComment("Конфликтов не обнаружено");
            } else {
                cellFullDTO.setStatus("fail");
            }
            cellFullDTOList.add(cellFullDTO);
        }
        return cellFullDTOList;
    }

    public ByteArrayOutputStream makePDF() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        List<Group> groups = groupDAO.getListOfGroups();
        List<Day> days = dayDAO.getAllDays();
        List<Pair> pairs = pairDAO.getListOfPairs();
        float[] cells = new float[groups.size() + 2];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = 1;
        }
        Document document = new Document();
        Font cellFont = FontFactory.getFont(FONT, "Cp1251", BaseFont.EMBEDDED);
        Font cellBoldFont = FontFactory.getFont(FONT, "Cp1251", BaseFont.EMBEDDED);
        PdfPTable table = new PdfPTable(cells);
        table.setWidthPercentage(90f);
        insertCell(table, "", cellBoldFont);
        insertCell(table, "", cellBoldFont);
        for (Group g : groups) {
            insertCell(table, g.getName() + "(" + g.getLanguage() + ")", cellBoldFont);
        }
        table.setHeaderRows(1);
        for (Day d : days) {
            String dayName = d.getName();
            insertRowspanCell(table, dayName, cellFont, 4 * pairs.size());
            for (Pair p : pairs) {
                insertRowspanCell(table, p.getBegin() + "-" + p.getEnd(), cellFont, 4);
                for (Group g : groups) {
                    /*List<Cell> cellList = cellDAO.getCellsByGroupAndPair(g.getId(), d.getId(), p.getId());
                    insertPairsCell(table, cellList, cellFont);*/
                    insertRowspanCell(table, "", cellFont, 4);
                }
            }
        }
        try {
            PdfWriter.getInstance(document, stream);
            document.open();
            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;
    }

    private static void insertCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(ALIGN_CENTER);
        table.addCell(cell);
    }

    private static void insertRowspanCell(PdfPTable table, String text, Font font, int rowspan) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(ALIGN_CENTER);
        cell.setRowspan(rowspan);
        table.addCell(cell);
    }

    private static void insertPairsCell(PdfPTable table, List<Cell> cells, Font font) {
        switch (cells.size()) {
            case 0:
                insertRowspanCell(table, "", font, 4);
                break;
            case 1:
                insertOnePair(table, cells, font);
                break;
        }
    }

    private static void insertOnePair(PdfPTable table, List<Cell> cells, Font font) {
        String text = "";
        Cell cell = cells.get(0);
        text += cell.getSubject().getAbbreviation() + "(" + cell.getType() + ")";
        text += cell.getLecturer().getSurname() + " " + cell.getLecturer().getName();
        if(cell.getCabinet() != null) {
            text += cell.getCabinet().getNumber() + "/" + cell.getCabinet().getBlock();
        }
        insertRowspanCell(table, text, font, 4);
    }
}
