package com.hazrody.cinema.service;

import com.hazrody.cinema.dao.entity.Actor;
import com.hazrody.cinema.dao.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public Page<Actor> getAllActor(PageRequest pageRequest) {
        return actorRepository.findAll(pageRequest);
    }

    public Actor createOrUpdateActor(Actor newActor) {
        return actorRepository.save(newActor);
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }


}
