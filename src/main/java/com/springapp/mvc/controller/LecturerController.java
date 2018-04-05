package com.springapp.mvc.controller;

import com.springapp.mvc.database.Lecturer;
import com.springapp.mvc.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    private LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    public List<Lecturer> getAllLecturers(){
        return lecturerService.getAllLecturers();
    }

    @GetMapping(value = "/add")
    public void addNewLecturer(@RequestParam("surname") String surname, @RequestParam("name") String name){
        lecturerService.addLecturer(new Lecturer(surname, name));
    }

    @GetMapping(value = "/update")
    public void updateLecturer(@RequestParam("id") int id, @RequestParam("surname") String surname, @RequestParam("name") String name){
        lecturerService.updateLecturer(id, new Lecturer(surname, name));
    }

    @GetMapping(value = "/delete")
    public void deleteLecturer(@RequestParam("id") int id){
        lecturerService.deleteLecturer(id);
    }
}
