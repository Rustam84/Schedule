package com.springapp.mvc.dao;

import com.springapp.mvc.database.Pair;

import java.util.List;

public interface PairDAO {
    public List<Pair> getListOfPairs();

    public void addPair(Pair pair);

    public void updatePair(int id, Pair pair);

    public void deletePair(int id);
}
