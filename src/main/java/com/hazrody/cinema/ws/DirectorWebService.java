package com.hazrody.cinema.ws;


import com.hazrody.cinema.dao.entity.Director;
import com.hazrody.cinema.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<Page<Director>> getAllDirector(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(directorService.getAllDirector(pageRequest));
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
