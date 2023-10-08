package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Parents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long ID;

    private String motherName;
    private String fatherName;
    private String address;
    private String tp;

    public  Parents(String motherName, String fatherName, String address, String tp) {
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.address = address;
        this.tp = tp;
    }

    public  Parents() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTp() {
        return tp;
    }

    public void setTP(String tp) {
        this.tp = tp;
    }

}
