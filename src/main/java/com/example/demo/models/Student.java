package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private  String grade;
    private  String room;
    private String tp;
    private LocalDate dob;
    @Transient
    private Integer age;

    @OneToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Parents parents;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )

    private final Set<Subjects>  subjects = new HashSet<>();

    public Student() {
    }

    public Student(String name,
                   String grade,
                   String room,
                   String tp,
                   LocalDate dob,
                   String email,
                   Parents parents) {
        this.name = name;
        this.grade = grade;
        this.room = room;
        this.tp = tp;
        this.dob = dob;
        this.email = email;
        this.parents = parents;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                ", room='" + room + '\'' +
                ", tp='" + tp + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }

}
