package com.springapp.mvc.dao;

import com.springapp.mvc.database.Subject;

import java.util.List;

public interface SubjectDAO {
    public List<Subject> getListOfSubjects();
    public void addSubject(Subject subject);
    public void updateSubject(int id, Subject subject);
    public void deleteSubject(int id);
}
