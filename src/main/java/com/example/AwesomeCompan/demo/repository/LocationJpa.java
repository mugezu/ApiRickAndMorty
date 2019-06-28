package com.example.AwesomeCompan.demo.repository;

import com.example.AwesomeCompan.demo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJpa extends JpaRepository<Location, Long> {
    Location findByUrl(String url);
}
