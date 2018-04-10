package com.springapp.mvc.database;

import com.springapp.mvc.enums.TypeOfCabinet;

import javax.persistence.*;

@Entity
@Table(name = "cabinet")
public class Cabinet {

    @Id
    @Column(name = "id_cabinet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "block")
    private String block;


    @Column(name = "capacity")
    private int capacity;

    @Enumerated
    @Column(name = "type")
    private TypeOfCabinet type;

    public Cabinet() {
    }

    public Cabinet(String number, String block, int capacity, TypeOfCabinet type) {
        this.number = number;
        this.block = block;
        this.capacity = capacity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public TypeOfCabinet getType() {
        return type;
    }

    public void setType(TypeOfCabinet type) {
        this.type = type;
    }
}
