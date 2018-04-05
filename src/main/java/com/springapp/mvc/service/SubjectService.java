package com.springapp.mvc.service;

import com.springapp.mvc.dao.SubjectDAO;
import com.springapp.mvc.database.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectService {

    private SubjectDAO subjectDAO;

    public SubjectService(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public List<Subject> getAllSubjects(){
        return subjectDAO.getListOfSubjects();
    }

    public void addSubject(Subject subject){
        subjectDAO.addSubject(subject);
    }

    public void updateSubject(int id, Subject subject){
        subjectDAO.updateSubject(id, subject);
    }

    public void deleteSubject(int id){
        subjectDAO.deleteSubject(id);
    }
}
