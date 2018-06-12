package com.springapp.mvc.dao;

import com.springapp.mvc.database.Cell;

import java.util.List;
import java.util.Optional;

public interface CellDAO {
    public Cell getCellById(int id);

    public List<Cell> getCellsWithoutDay();

    public List<Cell> getFilledCells();

    public List<Cell> getCellsWithLecturer(int idLecturer);

    public List<Cell> getCellsWithGroup(int idGroup);

    public void addCell(Cell cell);

    public void updateCell(int id, Cell cell);

    public void updateDayAndPairOfCell(int idCell, int idDay, int idPair);

    public void updateFullCell(int idCell, int idLecturer, int idSubject, String type, String parity, int idCabinet);

    public void removeDayAndPairOfCell(int idCell);

    public void deleteCell(int id);

    public int getCellByLecturerAndPair(int idLecturer, int idDay, int idPair, String parity);

    public int getCellByCabinetAndPair(int idCabinet, int idDay, int idPair, String parity);

    public int getCellByGroupAndPair(int idGroup, int idDay, int idPair, String parity);

    public List<Cell> getCellsByGroupAndPair(int idGroup, int idDay, int idPair);
}
