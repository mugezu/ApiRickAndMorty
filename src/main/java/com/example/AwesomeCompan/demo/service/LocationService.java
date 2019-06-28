package com.example.AwesomeCompan.demo.service;

import com.example.AwesomeCompan.demo.entity.Location;
import com.example.AwesomeCompan.demo.repository.LocationJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


@Service
public class LocationService {
    @Autowired
    LocationJpa locationJpa;

    public void updateAndSaveDate(List<Location> date) {
        List<Location> newDate = new LinkedList<>(date);

        for (Location e : newDate) {
            e.setResidents(new HashSet<>());
            e.setOrigins(new HashSet<>());
        }

        Location unknownLocation = locationJpa.findByUrl("");
        if (unknownLocation == null) {
            unknownLocation=new Location();
            unknownLocation.setUrl("");
            unknownLocation.setName("unknown");
            newDate.add(unknownLocation);
        }
        locationJpa.saveAll(newDate);
    }

    public List<Location> findAll() {
        return locationJpa.findAll();
    }

    public Location findByUrl(String url) {
        return locationJpa.findByUrl(url);
    }

    public Location findByUrl(List<Location> locations, String url) {
        for (Location l : locations) {
            if (l.getUrl().equals(url))
                return l;
        }
        return null;
    }
}
