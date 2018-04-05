package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.SubjectDAO;
import com.springapp.mvc.database.Subject;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDAOImplementation implements SubjectDAO {

    private SessionFactory sessionFactory;

    public SubjectDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Subject> getListOfSubjects() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Subject")
                .list();
    }

    @Override
    public void addSubject(Subject subject) {
        sessionFactory.getCurrentSession().save(subject);
    }

    @Override
    public void updateSubject(int id, Subject subject) {
        Subject newSubject = sessionFactory.getCurrentSession().get(Subject.class, id);
        newSubject.setName(subject.getName());
        newSubject.setAbbreviation(subject.getAbbreviation());
        sessionFactory.getCurrentSession().merge(newSubject);
    }

    @Override
    public void deleteSubject(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Subject.class, id));
    }
}
