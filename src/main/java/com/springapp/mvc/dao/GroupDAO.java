package com.springapp.mvc.dao;

import com.springapp.mvc.database.Group;

import java.util.List;

public interface GroupDAO {
    public List<Group> getListOfGroups();

    public void addGroup(Group group);

    public void updateGroup(int id, Group group);

    public void deleteGroup(int id);

    public Group getGroupById(int id);
}
