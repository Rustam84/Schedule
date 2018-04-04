package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.LecturerDAO;
import com.springapp.mvc.database.Lecturer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LecturerDAOImplementation implements LecturerDAO{

    @Autowired
    private SessionFactory sessionFactory;

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
}
