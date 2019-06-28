package com.example.AwesomeCompan.demo.component;

import com.example.AwesomeCompan.demo.entity.Character;
import com.example.AwesomeCompan.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class ScheduledTasks {

    @Autowired
    RickAndMortyAPI rickAndMortyAPI;
    @Autowired
    CharacterService characterService;
    @Autowired
    LocationService locationService;
    @Autowired
    EpisodeService episodeService;
    @Autowired
    LoggerService loggerService;


    @Scheduled(fixedRate = 3600000)
    public void updateDate() {
        loggerService.log.info("Start update {}", loggerService.dateFormat.format(new Date()));

        locationService.updateAndSaveDate(rickAndMortyAPI.getLocation());
        episodeService.updateAndSaveDate(rickAndMortyAPI.getEpisode());
        List<Character> characters = rickAndMortyAPI.getCharacters();
        characterService.saveDate(characterService.checkNewDate(characters));

        loggerService.log.info("Finish update {}", loggerService.dateFormat.format(new Date()));

    }

    @Scheduled(initialDelay = 1500, fixedRate = 360000000)
    public void updateImage() {
        loggerService.log.info("Start update image {}", loggerService.dateFormat.format(new Date()));

        characterService.updateAvatar();

        loggerService.log.info("Finish update image {}", loggerService.dateFormat.format(new Date()));
    }
}
