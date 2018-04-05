package com.springapp.mvc.service;

import com.springapp.mvc.dao.LecturerDAO;
import com.springapp.mvc.database.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LecturerService {

    private LecturerDAO lecturerDAO;

    public LecturerService(LecturerDAO lecturerDAO) {
        this.lecturerDAO = lecturerDAO;
    }

    public List<Lecturer> getAllLecturers() {
        return lecturerDAO.getListOfLecturers();
    }

    public void addLecturer(Lecturer lecturer) {
        lecturerDAO.addLecturer(lecturer);
    }

    public void updateLecturer(int id, Lecturer lecturer){
        lecturerDAO.updateLecturer(id, lecturer);
    }

    public void deleteLecturer(int id){
        lecturerDAO.deleteLecturer(id);
    }
}
