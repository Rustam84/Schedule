package com.springapp.mvc.controller;

import com.springapp.mvc.database.Cell;
import com.springapp.mvc.database.dto.CellDTO;
import com.springapp.mvc.database.dto.CellFullDTO;
import com.springapp.mvc.service.CellService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cell")
public class CellController {
    private CellService cellService;

    public CellController(CellService cellService) {
        this.cellService = cellService;
    }

    @RequestMapping("/getCellsWithoutDay")
    public List<CellDTO> getCellsWithoutDay(){
        return cellService.getCellsWithoutDay();
    }

    @RequestMapping("/getFilledCells")
    public List<CellFullDTO> getFilledCells(){
        return cellService.getCells();
    }

    @RequestMapping("/getCellsByLecturer")
    public List<CellFullDTO> getCellsByLecturer(@RequestParam("idLecturer") int idLecturer){
        return cellService.getCellsWithLecturer(idLecturer);
    }

    @RequestMapping("/add")
    public void addCell(@RequestParam("lecturer") int idLecturer, @RequestParam("subject") int idSubject, @RequestParam("group") String idGroups){
        cellService.addCell(idLecturer, idSubject, idGroups);
    }

    @RequestMapping("/delete")
    public void deleteCell(@RequestParam("id") int id){
        cellService.deleteCell(id);
    }

    @PostMapping("/updateDayAndPair")
    public void updateDayAndPair(@RequestParam("idCell") int idCell, @RequestParam("idPair") int idPair, @RequestParam("idDay") int idDay){
        cellService.updateDayAndPair(idCell, idDay, idPair);
    }

    @PostMapping("/removeDayAndPair")
    public void removeDayAndPair(@RequestParam("idCell") int idCell){
        cellService.removeDayAndPair(idCell);
    }
}
