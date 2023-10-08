package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Teachers {
    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;
    private String address;
    private String tp;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="subject_id", referencedColumnName = "id")
    private Subjects subjects;


    public Teachers(String name, String address, String tp, String email, LocalDate dob) {
        this.name = name;
        this.address = address;
        this.tp = tp;
        this.email = email;
        this.dob = dob;
    }


    public Teachers() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTP() {
        return tp;
    }

    public void setTP(String TP) {
        this.tp = TP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Teachers{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", address=" + address +
                ",tp=" + tp +
                '}';
    }
}
