package com.springapp.mvc.database.dto;

public class CellFullDTO extends CellDTO {

    int day;
    int pair;

    public CellFullDTO(int id, String name, String subject, String groups) {
        super(id, name, subject, groups);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPair() {
        return pair;
    }

    public void setPair(int pair) {
        this.pair = pair;
    }
}
