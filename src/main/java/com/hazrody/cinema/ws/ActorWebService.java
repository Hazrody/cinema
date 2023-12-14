package com.hazrody.cinema.ws;

import com.hazrody.cinema.dao.entity.Actor;
import com.hazrody.cinema.service.ActorService;
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
@RequestMapping("/actor")
@CrossOrigin(origins = "*")
public class ActorWebService {

    @Autowired
    ActorService actorService;

    @Operation(
            summary = "Récupèrer un acteur par son identifiant",
            description = "Récupèrer un acteur par son identifiant",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Actor.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant de l'acteur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getActor(@PathVariable("id") Long id) {
        Optional<Actor> actor = actorService.getActorById(id);
        if (actor.isPresent()) {
            return ResponseEntity.ok(actor.get());
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }

    @Operation(
            summary = "Récupèrer tous les acteur existant.",
            description = "Récupèrer tous les acteur existant.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Actor.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant de l'acteur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping("/")
    public ResponseEntity<Page<Actor>> getAllActor(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(actorService.getAllActor(pageRequest));
    }

    @Operation(
            summary = "Met à jour un acteur.",
            description = "Met à jour un acteur.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Actor.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant de l'acteur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PutMapping("/")
    public ResponseEntity<Actor> updateActor(
            @RequestBody Actor newActor) {
        return ResponseEntity.ok(
                actorService.createOrUpdateActor(newActor));
    }

    @Operation(
            summary = "Créer un acteur.",
            description = "Créer un acteur.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Actor.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Idenfiant de l'acteur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PostMapping("/")
    public ResponseEntity<Actor> createActor(
            @RequestBody Actor newActor) {
        return ResponseEntity.ok(
                actorService.createOrUpdateActor(newActor));
    }

    @Operation(
            summary = "Supprime un acteur par son identifiant.",
            description = "Supprime un acteur par son identifiant.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Actor.class))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Identifiant de l'acteur invalide",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") Long id) {
        actorService.deleteActor(id);
    }


}
