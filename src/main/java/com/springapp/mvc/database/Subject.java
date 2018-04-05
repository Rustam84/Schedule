package com.springapp.mvc.database;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "id_subject")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    public Subject() {
    }

    public Subject(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
