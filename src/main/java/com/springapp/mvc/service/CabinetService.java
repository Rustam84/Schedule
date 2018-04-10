package com.springapp.mvc.service;

import com.springapp.mvc.dao.CabinetDAO;
import com.springapp.mvc.database.Cabinet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CabinetService {

    private CabinetDAO cabinetDAO;

    public CabinetService(CabinetDAO cabinetDAO) {
        this.cabinetDAO = cabinetDAO;
    }

    public List<Cabinet> getAllCabinets(){
        return cabinetDAO.getListOfCabinets();
    }

    public void addCabinet(Cabinet cabinet){
        cabinetDAO.addCabinet(cabinet);
    }

    public void updateCabinet(int id, Cabinet cabinet){
        cabinetDAO.updateCabinet(id, cabinet);
    }

    public void deleteCabinet(int id){
        cabinetDAO.deleteCabinet(id);
    }
}
