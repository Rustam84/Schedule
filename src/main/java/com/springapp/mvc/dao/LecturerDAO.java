package com.springapp.mvc.dao;

import com.springapp.mvc.database.Lecturer;

import java.util.List;

public interface LecturerDAO {
    public List<Lecturer> getListOfLecturers();
    public void addLecturer(Lecturer lecturer);
    public void updateLecturer(int id, Lecturer lecturer);
    public void deleteLecturer(int id);
    public Lecturer getLectureById(int id);
}
