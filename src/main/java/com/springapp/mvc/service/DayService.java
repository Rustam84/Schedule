package com.springapp.mvc.service;

import com.springapp.mvc.dao.DayDAO;
import com.springapp.mvc.database.Day;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DayService {
    DayDAO dayDAO;

    public DayService(DayDAO dayDAO) {
        this.dayDAO = dayDAO;
    }

    public List<Day> getAllDays(){
        return  dayDAO.getAllDays();
    }
}
