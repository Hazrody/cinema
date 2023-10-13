package com.hazrody.cinema.dao.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private ZonedDateTime releaseDate;
    @ManyToOne
    @JoinColumn(name = "id_director", nullable = false)
    private Director director;
}
