package com.hazrody.cinema.ws;


import com.hazrody.cinema.dao.entity.Director;
import com.hazrody.cinema.service.DirectorService;
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
@RequestMapping("/director")
@CrossOrigin(origins = "*")
public class DirectorWebService {

    @Autowired
    DirectorService directorService;

    @Operation(
            summary = "Récupèrer un directeur par son identifiant",
            description = "Récupèrer un directeur par son identifiant",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Director.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du directeur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getDirector(@PathVariable("id") Long id) {
        Optional<Director> directorOptional = directorService.getDirectorById(id);
        if (directorOptional.isPresent()) {
            return ResponseEntity.ok(directorOptional.get());
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }

    @Operation(
            summary = "Récupèrer tous les directeur existants.",
            description = "Récupèrer tous les directeur existants.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Director.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du directeur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping("/")
    public ResponseEntity<Page<Director>> getAllDirector(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(directorService.getAllDirector(pageRequest));
    }


    @Operation(
            summary = "Met à jour un directeur.",
            description = "Met à jour un directeur.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Director.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du directeur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PutMapping("/")
    public ResponseEntity<Director> updateDirector(
            @RequestBody Director newDirector) {
        return ResponseEntity.ok(
                directorService.createOrUpdateDirector(newDirector));
    }

    @Operation(
            summary = "Créer un directeur.",
            description = "Créer un directeur.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Director.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du directeur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PostMapping("/")
    public ResponseEntity<Director> createDirector(
            @RequestBody Director newActor) {
        return ResponseEntity.ok(
                directorService.createOrUpdateDirector(newActor));
    }

    @Operation(
            summary = "Supprime un directeur par son identifiant.",
            description = "Supprime un directeur par son identifiant.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Director.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant du directeur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable("id") Long id) {
        directorService.deleteDirector(id);
    }
}
