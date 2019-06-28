package com.example.AwesomeCompan.demo.model;

import com.example.AwesomeCompan.demo.entity.Character;


import java.util.HashSet;
import java.util.Set;

public class JsonInfoCharacters{

    private Info info;
    private Set<Character> results = new HashSet<>();

    public void update(JsonInfoCharacters jsonInfo) {
        this.info = jsonInfo.getInfo();
        this.results.addAll(jsonInfo.results);
    }


    public JsonInfoCharacters() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Set<Character> getResults() {
        return results;
    }

    public void setResults(Set<Character> results) {
        this.results = results;
    }
}
