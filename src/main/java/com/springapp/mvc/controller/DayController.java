package com.springapp.mvc.controller;


import com.springapp.mvc.database.Day;
import com.springapp.mvc.service.DayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/day")
public class DayController {
    private DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @RequestMapping(value = "/getAll")
    public List<Day> getAllDays(){
        return dayService.getAllDays();
    }
}
