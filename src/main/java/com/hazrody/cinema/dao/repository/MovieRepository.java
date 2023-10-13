package com.hazrody.cinema.dao.repository;

import com.hazrody.cinema.dao.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
