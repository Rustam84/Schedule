package com.springapp.mvc.service;

import com.springapp.mvc.dao.CellDAO;
import com.springapp.mvc.dao.GroupDAO;
import com.springapp.mvc.dao.LecturerDAO;
import com.springapp.mvc.dao.SubjectDAO;
import com.springapp.mvc.database.Cell;
import com.springapp.mvc.database.Group;
import com.springapp.mvc.database.Lecturer;
import com.springapp.mvc.database.Subject;
import com.springapp.mvc.database.dto.CellDTO;
import com.springapp.mvc.database.dto.CellFullDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<CellFullDTO> getCellsWithLecturer(int idLecturer) {
        List<Cell> cellList = cellDAO.getCellsWithLecturer(idLecturer);
        List<CellFullDTO> cellFullDTOList = convertCellToFullDTO(cellList);
        return cellFullDTOList;
    }

    public void addCell(int idLecturer, int idSubject, String idGroups) {
        Cell cell = new Cell();
        Set<Group> groupSet = new HashSet<>();
        cell.setLecturer(lecturerDAO.getLectureById(idLecturer));
        cell.setSubject(subjectDAO.getSubjectById(idSubject));
        String groups[] = idGroups.split(",");
        for (String g : groups) {
            groupSet.add(groupDAO.getGroupById(new Integer(g)));
        }
        cell.setGroupSet(groupSet);
        cellDAO.addCell(cell);
    }

    public void updateCell(int id, Cell cell) {
        cellDAO.updateCell(id, cell);
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
            Lecturer lecturer = c.getLecturer();
            Subject subject = c.getSubject();
            Set<Group> groupSet = c.getGroupSet();
            String groups = "";
            for (Group g : groupSet) {
                groups += g.getName() + " ";
            }
            CellFullDTO cellFullDTO = new CellFullDTO(c.getId(), lecturer.getName() + " " + lecturer.getSurname(), subject.getName(), groups);
            cellFullDTO.setDay(c.getDay().getId());
            cellFullDTO.setPair(c.getPair().getId());
            cellFullDTOList.add(cellFullDTO);
        }
        return cellFullDTOList;
    }
}
