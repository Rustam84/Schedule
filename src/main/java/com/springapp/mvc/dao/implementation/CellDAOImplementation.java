package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.CellDAO;
import com.springapp.mvc.database.Cell;
import com.springapp.mvc.database.Day;
import com.springapp.mvc.database.Lecturer;
import com.springapp.mvc.database.Pair;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CellDAOImplementation implements CellDAO {

    SessionFactory sessionFactory;

    public CellDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Cell> getCellsWithoutDay() {
        return sessionFactory.getCurrentSession()
                .createQuery("select c from Cell c " +
                        "where c.pair = null and c.day = null")
                .list();
    }

    @Override
    public List<Cell> getFilledCells() {
        return sessionFactory.getCurrentSession()
                .createQuery("select c from Cell c " +
                        "where c.pair is not null and c.day is not null")
                .list();
    }

    @Override
    public void addCell(Cell cell) {
        sessionFactory.getCurrentSession().save(cell);
    }

    @Override
    public void updateCell(int id, Cell cell) {
        Cell newCell = sessionFactory.getCurrentSession().load(Cell.class, id);
        newCell.setLecturer(cell.getLecturer());
        newCell.setSubject(cell.getSubject());
        newCell.setGroupSet(cell.getGroupSet());
        newCell.setPair(cell.getPair());
        newCell.setDay(cell.getDay());
        newCell.setCabinet(cell.getCabinet());
        newCell.setParity(cell.getParity());
        newCell.setSubgroup(cell.getSubgroup());
        newCell.setType(cell.getType());
        sessionFactory.getCurrentSession().merge(newCell);
    }

    @Override
    public void deleteCell(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Cell.class,id));
    }

    @Override
    public void updateDayAndPairOfCell(int idCell, int idDay, int idPair) {
        Cell cell = sessionFactory.getCurrentSession().load(Cell.class, idCell);
        cell.setDay(sessionFactory.getCurrentSession().load(Day.class, idDay));
        cell.setPair(sessionFactory.getCurrentSession().load(Pair.class, idPair));
        sessionFactory.getCurrentSession().merge(cell);
    }

    @Override
    public void removeDayAndPairOfCell(int idCell) {
        Cell cell = sessionFactory.getCurrentSession().load(Cell.class, idCell);
        cell.setDay(null);
        cell.setPair(null);
        sessionFactory.getCurrentSession().merge(cell);
    }

    @Override
    public List<Cell> getCellsWithLecturer(int idLecturer) {
        Lecturer lecturer = sessionFactory.getCurrentSession().load(Lecturer.class, idLecturer);
        return sessionFactory.getCurrentSession()
                .createQuery("select c from Cell c " +
                        "where c.pair is not null and c.day is not null and c.lecturer = :lecturer")
                .setParameter("lecturer", lecturer)
                .list();
    }
}
