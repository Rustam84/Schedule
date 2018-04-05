package com.springapp.mvc.controller;

import com.springapp.mvc.database.Subject;
import com.springapp.mvc.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/getAll")
    public List<Subject> getAllSubjects(){
       return subjectService.getAllSubjects();
    }

    @GetMapping(value = "/add")
    public void addLecturer(@RequestParam("name") String name, @RequestParam("abbreviation") String abbreviation){
        subjectService.addSubject(new Subject(name, abbreviation));
    }

    @GetMapping(value = "/update")
    public void updateLecturer(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("abbreviation") String abbreviation){
        subjectService.updateSubject(id, new Subject(name, abbreviation));
    }

    @GetMapping(value = "/delete")
    public void deleteLecturer(@RequestParam("id") int id){
        subjectService.deleteSubject(id);
    }
}
