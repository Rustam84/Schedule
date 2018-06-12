package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.CellDAO;
import com.springapp.mvc.database.*;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Cell getCellById(int id) {
        Optional<Cell> cell = sessionFactory.getCurrentSession()
                .createQuery("select c from Cell c " +
                        "where c.pair is not null and c.day is not null and c.id = :id")
                .setParameter("id", id)
                .list().stream().findFirst();
        return cell.get();
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
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Cell.class, id));
    }

    @Override
    public void updateDayAndPairOfCell(int idCell, int idDay, int idPair) {
        Cell cell = sessionFactory.getCurrentSession().load(Cell.class, idCell);
        cell.setDay(sessionFactory.getCurrentSession().load(Day.class, idDay));
        cell.setPair(sessionFactory.getCurrentSession().load(Pair.class, idPair));
        sessionFactory.getCurrentSession().merge(cell);
    }

    @Override
    public void updateFullCell(int idCell, int idLecturer, int idSubject, String type, String parity, int idCabinet) {
        Cell cell = sessionFactory.getCurrentSession().load(Cell.class, idCell);
        cell.setLecturer(sessionFactory.getCurrentSession().load(Lecturer.class, idLecturer));
        cell.setSubject(sessionFactory.getCurrentSession().load(Subject.class, idSubject));
        cell.setType(type);
        cell.setParity(parity);
        if(idCabinet != 0) {
            cell.setCabinet(sessionFactory.getCurrentSession().load(Cabinet.class, idCabinet));
        } else {
            cell.setCabinet(null);
        }
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

    @Override
    public List<Cell> getCellsWithGroup(int idGroup) {
        return sessionFactory.getCurrentSession()
                .createQuery("select c from Cell as c " +
                        "join c.groupSet as g " +
                        "where c.pair is not null and c.day is not null and g.id = :idGroup")
                .setParameter("idGroup", idGroup)
                .list();
    }

    @Override
    public int getCellByLecturerAndPair(int idLecturer, int idDay, int idPair, String parity) {
        Lecturer lecturer = sessionFactory.getCurrentSession().load(Lecturer.class, idLecturer);
        Day day = sessionFactory.getCurrentSession().load(Day.class, idDay);
        Pair pair = sessionFactory.getCurrentSession().load(Pair.class, idPair);
        String query = "select c from Cell c " +
                "where c.pair = :pair and c.day = :day and c.lecturer = :lecturer ";
        if(parity.equals("0")){
            query += "and (c.parity = :parity or c.parity is not null)";
        } else {
            query += "and (c.parity = :parity or c.parity = '0')";
        }
        return sessionFactory.getCurrentSession()
                .createQuery(query)
                .setParameter("pair", pair)
                .setParameter("day", day)
                .setParameter("lecturer", lecturer)
                .setParameter("parity", parity)
                .list().size();
    }

    @Override
    public int getCellByCabinetAndPair(int idCabinet, int idDay, int idPair, String parity) {
        Cabinet cabinet = sessionFactory.getCurrentSession().load(Cabinet.class, idCabinet);
        Day day = sessionFactory.getCurrentSession().load(Day.class, idDay);
        Pair pair = sessionFactory.getCurrentSession().load(Pair.class, idPair);
        String query = "select c from Cell c " +
                "where c.pair = :pair and c.day = :day and c.cabinet = :cabinet ";
        if(parity.equals("0")){
            query += "and (c.parity = :parity or c.parity is not null)";
        } else {
            query += "and (c.parity = :parity or c.parity = '0')";
        }
        return sessionFactory.getCurrentSession()
                .createQuery(query)
                .setParameter("pair", pair)
                .setParameter("day", day)
                .setParameter("cabinet", cabinet)
                .setParameter("parity", parity)
                .list().size();
    }

    @Override
    public int getCellByGroupAndPair(int idGroup, int idDay, int idPair, String parity) {
        Group group = sessionFactory.getCurrentSession().load(Group.class, idGroup);
        Day day = sessionFactory.getCurrentSession().load(Day.class, idDay);
        Pair pair = sessionFactory.getCurrentSession().load(Pair.class, idPair);
        String query = "select c from Cell c join c.groupSet as gr" +
                " where c.pair = :pair and c.day =:day and gr.id = :idGroup ";
        if(parity.equals("0")){
            query += "and (c.parity = :parity or c.parity is not null)";
        } else {
            query += "and (c.parity = :parity or c.parity = '0')";
        }
        return sessionFactory.getCurrentSession()
                .createQuery(query)
                .setParameter("pair", pair)
                .setParameter("day", day)
                .setParameter("idGroup", idGroup)
                .setParameter("parity", parity)
                .list().size();
    }

    @Override
    public List<Cell> getCellsByGroupAndPair(int idGroup, int idDay, int idPair) {
        Group group = sessionFactory.getCurrentSession().load(Group.class, idGroup);
        Day day = sessionFactory.getCurrentSession().load(Day.class, idDay);
        Pair pair = sessionFactory.getCurrentSession().load(Pair.class, idPair);
        String query = "select c from Cell c join c.groupSet as gr" +
                " where c.pair = :pair and c.day =:day and gr.id = :idGroup";
        return sessionFactory.getCurrentSession()
                .createQuery(query)
                .setParameter("pair", pair)
                .setParameter("day", day)
                .setParameter("idGroup", idGroup)
                .list();
    }
}
