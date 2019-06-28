package com.example.AwesomeCompan.demo.repository;

import com.example.AwesomeCompan.demo.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeJpa extends JpaRepository<Episode, Long> {

}
