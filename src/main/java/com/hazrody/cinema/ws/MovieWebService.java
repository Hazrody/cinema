package com.hazrody.cinema.ws;


import com.hazrody.cinema.dao.entity.Movie;
import com.hazrody.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*")
public class MovieWebService {

    @Autowired
    MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovie(@PathVariable("id") Long id) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        if (movieOptional.isPresent()) {
            return ResponseEntity.ok(movieOptional.get());
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }

    @GetMapping("/")
    public ResponseEntity<Page<Movie>> getAllMovie(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(movieService.getAllMovie(pageRequest));
    }

    @PutMapping("/")
    public ResponseEntity<Movie> updateMovie(
            @RequestBody Movie newMovie) {
        return ResponseEntity.ok(
                movieService.createOrUpdateMovie(newMovie));
    }

    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(
            @RequestBody Movie newActor) {
        return ResponseEntity.ok(
                movieService.createOrUpdateMovie(newActor));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
    }


}
