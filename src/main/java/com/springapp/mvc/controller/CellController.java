package com.springapp.mvc.controller;

import com.springapp.mvc.database.Cell;
import com.springapp.mvc.database.dto.CellDTO;
import com.springapp.mvc.database.dto.CellFullDTO;
import com.springapp.mvc.service.CellService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/cell")
public class CellController {
    private CellService cellService;

    public CellController(CellService cellService) {
        this.cellService = cellService;
    }

    @RequestMapping("/getCellsWithoutDay")
    public List<CellDTO> getCellsWithoutDay() {
        return cellService.getCellsWithoutDay();
    }

    @RequestMapping("/getFilledCells")
    public List<CellFullDTO> getFilledCells() {
        return cellService.getCells();
    }

    @RequestMapping("/getCellsByLecturer")
    public List<CellFullDTO> getCellsByLecturer(@RequestParam("idLecturer") int idLecturer) {
        return cellService.getCellsWithLecturer(idLecturer);
    }

    @RequestMapping("/getCellsByGroup")
    public List<CellFullDTO> getCellsByGroup(@RequestParam("idGroup") int idGroup) {
        return cellService.getCellsWithGroup(idGroup);
    }

    @RequestMapping("/add")
    public void addCell(@RequestParam("lecturer") int idLecturer, @RequestParam("subject") int idSubject, @RequestParam("group") String idGroups, @RequestParam("type") String type, @RequestParam("number") int number) {
        for (int i = 1; i <= number; i++) {
            cellService.addCell(idLecturer, idSubject, idGroups, type);
        }
    }

    @RequestMapping("/getById")
    public CellFullDTO getById(@RequestParam("id") int id) {
        return cellService.getCellById(id);
    }

    @RequestMapping("/delete")
    public void deleteCell(@RequestParam("id") int id) {
        cellService.deleteCell(id);
    }

    @PostMapping("/updateDayAndPair")
    public void updateDayAndPair(@RequestParam("idCell") int idCell, @RequestParam("idPair") int idPair, @RequestParam("idDay") int idDay) {
        cellService.updateDayAndPair(idCell, idDay, idPair);
    }

    @PostMapping("/removeDayAndPair")
    public void removeDayAndPair(@RequestParam("idCell") int idCell) {
        cellService.removeDayAndPair(idCell);
    }

    @PostMapping("/updateFullCell")
    public void updateFullCell(@RequestParam("idCell") int idCell,
                               @RequestParam("idLecturer") int idLecturer,
                               @RequestParam("idSubject") int idSubject,
                               @RequestParam("type") String type,
                               @RequestParam("parity") String parity,
                               @RequestParam("idCabinet") int idCabinet) {
        cellService.updateFullCell(idCell, idLecturer, idSubject, type, parity, idCabinet);
    }

    @GetMapping(value = "/getPDF", produces = "application/pdf")
    public byte[] getPDF() {
        ByteArrayOutputStream stream = cellService.makePDF();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Encoding", "UTF-8");
        return stream.toByteArray();
    }
}
