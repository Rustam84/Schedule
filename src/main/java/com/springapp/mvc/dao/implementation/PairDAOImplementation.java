package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.PairDAO;
import com.springapp.mvc.database.Pair;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PairDAOImplementation implements PairDAO {

    private SessionFactory sessionFactory;

    public PairDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Pair> getListOfPairs() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Pair")
                .list();
    }

    @Override
    public void addPair(Pair pair) {
        sessionFactory.getCurrentSession().save(pair);
    }

    @Override
    public void updatePair(int id, Pair pair) {
        Pair newPair = sessionFactory.getCurrentSession().get(Pair.class, id);
        newPair.setNumber(pair.getNumber());
        newPair.setBegin(pair.getBegin());
        newPair.setEnd(pair.getEnd());
        sessionFactory.getCurrentSession().merge(pair);
    }

    @Override
    public void deletePair(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Pair.class, id));
    }
}
