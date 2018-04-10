package com.springapp.mvc.controller;

import com.springapp.mvc.database.Cabinet;
import com.springapp.mvc.service.CabinetService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cabinet")
public class CabinetController {

    private CabinetService cabinetService;

    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @RequestMapping("/getAll")
    public List<Cabinet> getAllCabinets(){
        return cabinetService.getAllCabinets();
    }

    @RequestMapping("/add")
    public void addCabinet(@ModelAttribute("cabinet") Cabinet cabinet){
        cabinetService.addCabinet(cabinet);
    }

    @RequestMapping("/update")
    public void updateCabinet(@RequestParam("id") int id, @ModelAttribute("cabinet") Cabinet cabinet){
        cabinetService.updateCabinet(id, cabinet);
    }

    @RequestMapping("/delete")
    public void deleteCabinet(@RequestParam("id") int id){
        cabinetService.deleteCabinet(id);
    }
}
