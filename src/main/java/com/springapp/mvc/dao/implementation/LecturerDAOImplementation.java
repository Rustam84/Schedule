package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.LecturerDAO;
import com.springapp.mvc.database.Lecturer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LecturerDAOImplementation implements LecturerDAO {

    private SessionFactory sessionFactory;

    public LecturerDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Lecturer> getListOfLecturers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Lecturer")
                .list();
    }

    @Override
    public void addLecturer(Lecturer lecturer) {
        sessionFactory.getCurrentSession().save(lecturer);
    }

    @Override
    public void updateLecturer(int id, Lecturer lecturer) {
        Lecturer newLecturer = sessionFactory.getCurrentSession().get(Lecturer.class, id);
        newLecturer.setName(lecturer.getName());
        newLecturer.setSurname(lecturer.getSurname());
        sessionFactory.getCurrentSession().merge(newLecturer);
    }

    @Override
    public void deleteLecturer(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Lecturer.class, id));
    }

    @Override
    public Lecturer getLectureById(int id) {
        return sessionFactory.getCurrentSession().get(Lecturer.class, id);
    }
}
