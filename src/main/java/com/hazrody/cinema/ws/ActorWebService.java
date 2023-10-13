package com.hazrody.cinema.ws;

import com.hazrody.cinema.dao.entity.Actor;
import com.hazrody.cinema.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
@CrossOrigin(origins = "*")
public class ActorWebService {

    @Autowired
    ActorService actorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getActor(@PathVariable("id") Long id) {
        Optional<Actor> actor = actorService.getActorById(id);
        if (actor.isPresent()) {
            return ResponseEntity.ok(actor.get());
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Actor>> getAllActor() {
        return ResponseEntity.ok(actorService.getAllActor());
    }

    @PutMapping("/")
    public ResponseEntity<Actor> updateActor(
            @RequestBody Actor newActor) {
        return ResponseEntity.ok(
                actorService.createOrUpdateActor(newActor));
    }

    @PostMapping("/")
    public ResponseEntity<Actor> createActor(
            @RequestBody Actor newActor) {
        return ResponseEntity.ok(
                actorService.createOrUpdateActor(newActor));
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") Long id) {
        actorService.deleteActor(id);
    }


}
