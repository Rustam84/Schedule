package com.springapp.mvc.service;

import com.springapp.mvc.dao.GroupDAO;
import com.springapp.mvc.database.Group;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupService {

    private GroupDAO groupDAO;

    public GroupService(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public List<Group> getAllGroups() {
        return groupDAO.getListOfGroups();
    }

    public void addGroup(Group group) {
        groupDAO.addGroup(group);
    }

    public void updateGroup(int id, Group group) {
        groupDAO.updateGroup(id, group);
    }

    public void deleteGroup(int id) {
        groupDAO.deleteGroup(id);
    }
}
