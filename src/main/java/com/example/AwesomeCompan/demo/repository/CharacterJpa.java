package com.example.AwesomeCompan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.AwesomeCompan.demo.entity.Character;

import java.util.List;

@Repository
public interface CharacterJpa extends JpaRepository<Character, Long> {
    @Query("SELECT max (id) FROM Character ")
    Long findByMaxId();

    @Query("SELECT c FROM Character c WHERE LOWER(c.name) LIKE LOWER(concat('%',?1,'%'))")
    List<Character> findByNameContains(String name);

}
