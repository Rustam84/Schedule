package com.springapp.mvc.service;

import com.springapp.mvc.dao.PairDAO;
import com.springapp.mvc.database.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PairService {

    private PairDAO pairDAO;

    public PairService(PairDAO pairDAO) {
        this.pairDAO = pairDAO;
    }

    public List<Pair> getAllPairs(){
        return pairDAO.getListOfPairs();
    }

    public void addPair(Pair pair){
        pairDAO.addPair(pair);
    }

    public void updatePair(int id, Pair pair){
        pairDAO.updatePair(id, pair);
    }

    public void deletePair(int id){
        pairDAO.deletePair(id);
    }
}
