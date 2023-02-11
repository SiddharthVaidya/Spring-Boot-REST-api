package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Student {
    private String name;
    private String email;
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
    private Integer id;
    private LocalDate dob;
    private Long age;

    public Student() {
    }

    public Student(String name, String email, Integer id, LocalDate dob, Long age) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.dob = dob;
        this.age = age;
    }

    public Student(String name, String email, LocalDate dob, Long age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
