package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private LocalDate birth;
    private String email;

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email, Integer age) {
        Id = id;
        this.name = name;
        this.birth = dob;
        this.email = email;
        this.age = age;
    }

    public Student(String name, LocalDate dob, String email, Integer age) {
        this.name = name;
        this.birth = dob;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge(

    ) {
        return Period.between(this.birth, LocalDate.now()).getYears();

    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", dob=" + birth +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
