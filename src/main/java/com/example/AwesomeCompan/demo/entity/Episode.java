package com.example.AwesomeCompan.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String created;
    private String air_date;
    private String episode;
    @ManyToMany(mappedBy = "episode", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Character> characters = new HashSet<>();

    public Episode() {
    }

    public Episode(String url) {
        this.url = url;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "Name='" + name + '\'' +
                ", air_date='" + air_date + '\'' +
                ", episode='" + episode + '\'' +
                ", characters=" + characters +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return Objects.equals(name, episode.name) &&
                Objects.equals(url, episode.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }
}
