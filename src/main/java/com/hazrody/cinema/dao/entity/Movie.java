package com.hazrody.cinema.dao.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.List;

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
    @ManyToMany
    @JoinTable(
            name = "play_role",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_actor")
    )
    List<Actor> actorList;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(ZonedDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
