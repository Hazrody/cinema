package com.hazrody.cinema.dao.repository;

import com.hazrody.cinema.dao.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Long, Director> {
}
