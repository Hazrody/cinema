package com.hazrody.cinema.service;

import com.hazrody.cinema.dao.entity.Movie;
import com.hazrody.cinema.dao.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Page<Movie> getAllMovie(PageRequest pageRequest) {
        return movieRepository.findAll(pageRequest);
    }

    public Movie createOrUpdateMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
