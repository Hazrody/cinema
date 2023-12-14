package com.hazrody.cinema.service;


import com.hazrody.cinema.dao.entity.Director;
import com.hazrody.cinema.dao.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    public Page<Director> getAllDirector(PageRequest pageRequest) {
        return directorRepository.findAll(pageRequest);
    }

    public Director createOrUpdateDirector(Director newDirector) {
        return directorRepository.save(newDirector);
    }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
}
