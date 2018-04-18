package com.springapp.mvc.database.dto;

public class CellDTO {
    int id;
    String name;
    String subject;
    String groups;

    public CellDTO() {
    }

    public CellDTO(int id, String name, String subject, String groups) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}
