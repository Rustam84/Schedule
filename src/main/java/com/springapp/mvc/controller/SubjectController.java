package com.springapp.mvc.controller;

import com.springapp.mvc.database.Subject;
import com.springapp.mvc.service.SubjectService;
import org.springframework.web.bind.annotation.*;

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
    public void addLecturer(@ModelAttribute("subject") Subject subject){
        subjectService.addSubject(subject);
    }

    @GetMapping(value = "/update")
    public void updateLecturer(@RequestParam("id") int id, @ModelAttribute("subject") Subject subject){
        subjectService.updateSubject(id, subject);
    }

    @GetMapping(value = "/delete")
    public void deleteLecturer(@RequestParam("id") int id){
        subjectService.deleteSubject(id);
    }
}
