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

    public Lecturer addLecturer(Lecturer lecturer) {
        lecturerDAO.addLecturer(lecturer);
        return lecturer;
    }
}
