package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.CabinetDAO;
import com.springapp.mvc.database.Cabinet;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CabinetDAOImplementation implements CabinetDAO {

    private SessionFactory sessionFactory;

    public CabinetDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Cabinet> getListOfCabinets() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Cabinet")
                .list();
    }

    @Override
    public void addCabinet(Cabinet cabinet) {
        sessionFactory.getCurrentSession().save(cabinet);
    }

    @Override
    public void updateCabinet(int id, Cabinet cabinet) {
        Cabinet newCabinet = sessionFactory.getCurrentSession().get(Cabinet.class, id);
        newCabinet.setBlock(cabinet.getBlock());
        newCabinet.setCapacity(cabinet.getCapacity());
        newCabinet.setNumber(cabinet.getNumber());
        newCabinet.setType(cabinet.getType());
        sessionFactory.getCurrentSession().merge(newCabinet);
    }

    @Override
    public void deleteCabinet(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Cabinet.class, id));
    }
}
