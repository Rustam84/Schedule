package com.springapp.mvc.controller;

import com.springapp.mvc.database.Pair;
import com.springapp.mvc.service.PairService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pair")
public class PairController {

    private PairService pairService;

    public PairController(PairService pairService) {
        this.pairService = pairService;
    }

    @RequestMapping("/getAll")
    public List<Pair> getAllPairs(){
        return pairService.getAllPairs();
    }

    @RequestMapping("/add")
    public void addPair(@ModelAttribute("pair") Pair pair){
        pairService.addPair(pair);
    }

    @RequestMapping("/update")
    public void updatePair(@RequestParam("id") int id, @ModelAttribute("pair") Pair pair){
        pairService.updatePair(id, pair);
    }

    @RequestMapping("/delete")
    public void deletePair(@RequestParam("id") int id){
        pairService.deletePair(id);
    }
}
