package com.example.AwesomeCompan.demo.model;

import com.example.AwesomeCompan.demo.entity.Episode;

import java.util.HashSet;
import java.util.Set;

public class JsonInfoEpisode {

    private Info info;
    private Set<Episode> results = new HashSet<>();

    public void update(JsonInfoEpisode jsonInfo) {
        this.info = jsonInfo.getInfo();
        this.results.addAll(jsonInfo.results);
    }

    public JsonInfoEpisode() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Set<Episode> getResults() {
        return results;
    }

    public void setResults(Set<Episode> results) {
        this.results = results;
    }
}
