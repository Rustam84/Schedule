package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.DayDAO;
import com.springapp.mvc.database.Day;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DayDAOImplementation implements DayDAO {

    SessionFactory sessionFactory;

    public DayDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Day> getAllDays() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Day")
                .list();
    }
}
