package com.springapp.mvc.dao;

import com.springapp.mvc.database.Cabinet;

import java.util.List;

public interface CabinetDAO {

    public List<Cabinet> getListOfCabinets();

    public void addCabinet(Cabinet cabinet);

    public void updateCabinet(int id, Cabinet cabinet);

    public void deleteCabinet(int id);
}
