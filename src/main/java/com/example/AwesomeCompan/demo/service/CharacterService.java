package com.example.AwesomeCompan.demo.service;

import com.example.AwesomeCompan.demo.entity.Character;
import com.example.AwesomeCompan.demo.entity.Episode;
import com.example.AwesomeCompan.demo.entity.Location;
import com.example.AwesomeCompan.demo.repository.CharacterJpa;
import com.example.AwesomeCompan.demo.repository.EpisodeJpa;
import com.example.AwesomeCompan.demo.repository.LocationJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CharacterService {
    @Autowired
    LoggerService loggerService;
    @Autowired
    private CharacterJpa characterJpa;
    @Autowired
    private LocationService locationService;
    @Autowired
    private EpisodeService episodeService;

    public void saveDate(List<Character> date) {
        loggerService.log.info("Start update and save characters({}) {}", date.size(), loggerService.dateFormat.format(new Date()));

        List<Character> newDate = new LinkedList<>(date);
        List<Episode> episodes = episodeService.findAll();
        List<Location> locations = locationService.findAll();
        for (Character e : newDate) {
            e.setEpisode(episodeService.findByUrl(episodes, e.getEpisode()));

            Location location = locationService.findByUrl(locations, e.getLocation().getUrl());
            Location locationOrigin;
            if (e.getLocation().getUrl().equals(e.getOrigin().getUrl())) {
                locationOrigin = location;
            } else
                locationOrigin = locationService.findByUrl(locations, e.getOrigin().getUrl());
            if (location != null)
                e.setLocation(location);
            else
                e.setLocation(null);

            if (locationOrigin != null)
                e.setOrigin(locationOrigin);
            else
                e.setOrigin(null);
        }

        characterJpa.saveAll(newDate);
        loggerService.log.info("Finish update and save characters({}) {}", date.size(), loggerService.dateFormat.format(new Date()));
    }

    public List<Character> checkNewDate(List<Character> date) {
        List<Character> newDate = new LinkedList<>();
        List<Character> dateDB = characterJpa.findAll();
        boolean flag = false;
        for (Character c : date) {
            flag = false;
            for (Character c1 : dateDB) {
                if (c.equals(c1)) {
                    flag = true;
                    continue;
                }
            }
            if (!flag) {
                newDate.add(c);
            }
        }
        return newDate;
    }

    public void updateAvatar() {
        List<Character> characters = characterJpa.findAll();
        for (Character character : characters) {
            new UtilService().fileStream(character);
        }
        characterJpa.saveAll(characters);
    }

    public Character findCharacter(Long id) {
        return characterJpa.findById(id).get();
    }

    public Long findByMaxId() {
        return characterJpa.findByMaxId();
    }

    public List<Character> findByName(String name) {
        return characterJpa.findByNameContains(name);
    }
}
