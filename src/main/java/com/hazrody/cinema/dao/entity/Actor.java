package com.hazrody.cinema.dao.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String firstName;

    private ZonedDateTime birthDay;

    //private boolean isDirector;

    @Id
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ZonedDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(ZonedDateTime birthDay) {
        this.birthDay = birthDay;
    }
}
