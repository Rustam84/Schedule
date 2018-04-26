package com.springapp.mvc.service;

import com.springapp.mvc.dao.CellDAO;
import com.springapp.mvc.dao.GroupDAO;
import com.springapp.mvc.dao.LecturerDAO;
import com.springapp.mvc.dao.SubjectDAO;
import com.springapp.mvc.database.*;
import com.springapp.mvc.database.dto.CellDTO;
import com.springapp.mvc.database.dto.CellFullDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CellService {
    private CellDAO cellDAO;
    private LecturerDAO lecturerDAO;
    private SubjectDAO subjectDAO;
    private GroupDAO groupDAO;

    public CellService(CellDAO cellDAO, LecturerDAO lecturerDAO, SubjectDAO subjectDAO, GroupDAO groupDAO) {
        this.cellDAO = cellDAO;
        this.lecturerDAO = lecturerDAO;
        this.subjectDAO = subjectDAO;
        this.groupDAO = groupDAO;
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
            if (cellDAO.getCellByLecturerAndPair(lecturer.getId(), c.getDay().getId(), c.getPair().getId(), c.getParity()) == 1) {
                status = true;
            } else {
                status = false;
                cellFullDTO.setComment(cellFullDTO.getComment() + "Преподаватель " + lecturer.getSurname() + " " + lecturer.getName() + " уже имеет пару в это время.<br />");
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
}
