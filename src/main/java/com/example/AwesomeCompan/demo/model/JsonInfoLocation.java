package com.example.AwesomeCompan.demo.model;

import com.example.AwesomeCompan.demo.entity.Location;

import java.util.HashSet;
import java.util.Set;

public class JsonInfoLocation {

    private Info info;
    private Set<Location> results = new HashSet<>();

    public void update(JsonInfoLocation jsonInfo) {
        this.info = jsonInfo.getInfo();
        this.results.addAll(jsonInfo.results);
    }

    public JsonInfoLocation() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Set<Location> getResults() {
        return results;
    }

    public void setResults(Set<Location> results) {
        this.results = results;
    }
}
