package com.springapp.mvc.database;

import com.springapp.mvc.enums.Language;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="groupa")
public class Group {

    @Id
    @Column(name = "id_group")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated
    @Column(name = "language")
    private Language language;

    @Column(name = "number_of_students")
    private int numberOfStudents;

    public Group() {
    }

    public Group(String name, Language language, int numberOfStudents) {
        this.name = name;
        this.language = language;
        this.numberOfStudents = numberOfStudents;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}
