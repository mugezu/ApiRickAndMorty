package com.example.AwesomeCompan.demo.service;

import com.example.AwesomeCompan.demo.entity.Episode;
import com.example.AwesomeCompan.demo.repository.EpisodeJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class EpisodeService {
    @Autowired
    EpisodeJpa episodeJpa;

    public void updateAndSaveDate(List<Episode> date) {
        List<Episode> newDate = new LinkedList<>(date);
        for (Episode e : newDate) {
            e.setCharacters(new HashSet<>());
        }
        episodeJpa.saveAll(newDate);
    }

    public List<Episode> findAll() {
        return episodeJpa.findAll();
    }

    public Set<Episode> findByUrl(List<Episode> episodesInDB, Set<Episode> episodes) {
        Set<Episode> result = new HashSet<>();
        for (Episode e : episodesInDB) {
            for (Episode ee : episodes) {
                if (e.getUrl().equals(ee.getUrl())) {
                    result.add(e);
                }
            }
        }
        return result;
    }
}
