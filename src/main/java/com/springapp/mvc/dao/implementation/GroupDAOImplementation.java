package com.springapp.mvc.dao.implementation;

import com.springapp.mvc.dao.GroupDAO;
import com.springapp.mvc.database.Group;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDAOImplementation implements GroupDAO {

    private SessionFactory sessionFactory;

    public GroupDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Group> getListOfGroups() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Group")
                .list();
    }

    @Override
    public void addGroup(Group group) {
        sessionFactory.getCurrentSession().save(group);
    }

    @Override
    public void updateGroup(int id, Group group) {
        Group newGroup = sessionFactory.getCurrentSession().get(Group.class, id);
        newGroup.setLanguage(group.getLanguage());
        newGroup.setName(group.getName());
        newGroup.setNumberOfStudents(group.getNumberOfStudents());
        sessionFactory.getCurrentSession().merge(newGroup);
    }

    @Override
    public void deleteGroup(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Group.class, id));
    }
}
