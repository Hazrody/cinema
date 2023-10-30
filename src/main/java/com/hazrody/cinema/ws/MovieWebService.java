package com.hazrody.cinema.ws;



import com.hazrody.cinema.dao.entity.Movie;
import com.hazrody.cinema.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*")
public class MovieWebService {

    @Autowired
    MovieService movieService;

    @Operation(
            summary = "Récupère un film par son identifiant.",
            description = "Récupère un film par son identifiant.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Movie.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du film invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getMovie(@PathVariable("id") Long id) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        if (movieOptional.isPresent()) {
            return ResponseEntity.ok(movieOptional.get());
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }

    @Operation(
            summary = "Récupère tous les films existants.",
            description = "Récupère tous les films existants.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Movie.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du film invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping("/")
    public ResponseEntity<Page<Movie>> getAllMovie(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(movieService.getAllMovie(pageRequest));
    }

    @Operation(
            summary = "Met à jour un film existant.",
            description = "Met à jour un film existant.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Movie.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du film invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PutMapping("/")
    public ResponseEntity<Movie> updateMovie(
            @RequestBody Movie newMovie) {
        return ResponseEntity.ok(
                movieService.createOrUpdateMovie(newMovie));
    }

    @Operation(
            summary = "Création d'un film.",
            description = "Création d'un film.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Movie.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du film invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(
            @RequestBody Movie newActor) {
        return ResponseEntity.ok(
                movieService.createOrUpdateMovie(newActor));
    }

    @Operation(
            summary = "Supprime un film par son identifiant.",
            description = "Supprime un film par son identifiant.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Movie.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du film invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
    }


}
