package com.springapp.mvc.dao;

import com.springapp.mvc.database.Cell;

import java.util.List;

public interface CellDAO {
    public List<Cell> getCellsWithoutDay();

    public List<Cell> getFilledCells();

    public List<Cell> getCellsWithLecturer(int idLecturer);

    public void addCell(Cell cell);

    public void updateCell(int id, Cell cell);

    public void updateDayAndPairOfCell(int idCell, int idDay, int idPair);

    public void removeDayAndPairOfCell(int idCell);

    public void deleteCell(int id);
}
