package com.hazrody.cinema.ws;


import com.hazrody.cinema.dao.entity.Director;
import com.hazrody.cinema.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/director")
@CrossOrigin(origins = "*")
public class DirectorWebService {

    @Autowired
    DirectorService directorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getDirector(@PathVariable("id") Long id) {
        Optional<Director> directorOptional = directorService.getDirectorById(id);
        if (directorOptional.isPresent()) {
            return ResponseEntity.ok(directorOptional.get());
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Director>> getAllDirector() {
        return ResponseEntity.ok(directorService.getAllDirector());
    }

    @PutMapping("/")
    public ResponseEntity<Director> updateDirector(
            @RequestBody Director newDirector) {
        return ResponseEntity.ok(
                directorService.createOrUpdateDirector(newDirector));
    }

    @PostMapping("/")
    public ResponseEntity<Director> createDirector(
            @RequestBody Director newActor) {
        return ResponseEntity.ok(
                directorService.createOrUpdateDirector(newActor));
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable("id") Long id) {
        directorService.deleteDirector(id);
    }
}
