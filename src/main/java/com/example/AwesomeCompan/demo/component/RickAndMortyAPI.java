package com.example.AwesomeCompan.demo.component;

import com.example.AwesomeCompan.demo.entity.Character;
import com.example.AwesomeCompan.demo.entity.Episode;
import com.example.AwesomeCompan.demo.entity.Location;
import com.example.AwesomeCompan.demo.model.JsonInfoCharacters;
import com.example.AwesomeCompan.demo.model.JsonInfoEpisode;
import com.example.AwesomeCompan.demo.model.JsonInfoLocation;
import com.example.AwesomeCompan.demo.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RickAndMortyAPI {
    @Autowired
    LoggerService loggerService;

    public List<Character> getCharacters(){
        RestTemplate restTemplate = new RestTemplate();
        String link = "https://rickandmortyapi.com/api/character/";
        loggerService.log.info("Start getting character data  {}", loggerService.dateFormat.format(new Date()));

        JsonInfoCharacters result = restTemplate.getForObject(link, JsonInfoCharacters.class);
        while (!result.getInfo().getNext().equals("")) {
            result.update(restTemplate.getForObject(result.getInfo().getNext(), JsonInfoCharacters.class));
        }

        List<Character> sortedDate = result.getResults().stream().collect(Collectors.toList());
        Collections.sort(sortedDate, (o1, o2) -> o1.getId().compareTo(o2.getId()));

        loggerService.log.info("Finish getting character data {}", loggerService.dateFormat.format(new Date()));
        return sortedDate;
    }

    public List<Episode> getEpisode() {
        RestTemplate restTemplate = new RestTemplate();
        String link = "https://rickandmortyapi.com/api/episode/";
        loggerService.log.info("Start getting episodes data {}", loggerService.dateFormat.format(new Date()));

        JsonInfoEpisode result = restTemplate.getForObject(link, JsonInfoEpisode.class);
        while (!result.getInfo().getNext().equals("")) {
            result.update(restTemplate.getForObject(result.getInfo().getNext(), JsonInfoEpisode.class));
        }

        List<Character> res = new ArrayList<>();
        Set<Character> res1 = new HashSet<>();

        for (Episode l : result.getResults()) {
            res.addAll(l.getCharacters());
            res1.addAll(l.getCharacters());
        }
        List<Episode> sortedDate = result.getResults().stream().collect(Collectors.toList());
        Collections.sort(sortedDate, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        loggerService.log.info("Finish getting episodes data {}", loggerService.dateFormat.format(new Date()));
        return sortedDate;
    }

    public List<Location> getLocation() {
        RestTemplate restTemplate = new RestTemplate();
        String link = "https://rickandmortyapi.com/api/location/";
        loggerService.log.info("Start getting location data {}", loggerService.dateFormat.format(new Date()));

        JsonInfoLocation result = restTemplate.getForObject(link, JsonInfoLocation.class);
        while (!result.getInfo().getNext().equals("")) {
            result.update(restTemplate.getForObject(result.getInfo().getNext(), JsonInfoLocation.class));
        }

        List<Character> res = new ArrayList<>();

        for (Location l : result.getResults()) {
            res.addAll(l.getResidents());
        }
        List<Location> sortedDate = result.getResults().stream().collect(Collectors.toList());
        Collections.sort(sortedDate, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        loggerService.log.info("Finish getting location data {}", loggerService.dateFormat.format(new Date()));
        return sortedDate;
    }
}

