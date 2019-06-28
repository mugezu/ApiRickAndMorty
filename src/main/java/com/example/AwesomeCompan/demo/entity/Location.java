package com.example.AwesomeCompan.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String created;
    private String type;
    private String dimension;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origin", fetch = FetchType.EAGER)
    private Set<Character> origins = new HashSet<>();
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "location",fetch = FetchType.EAGER)
    private Set<Character> residents = new HashSet<>();

    public Location() {
    }

    public Location(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Set<Character> getResidents() {
        return residents;
    }

    public void setResidents(Set<Character> residents) {
        this.residents = residents;
    }

    public Set<Character> getOrigins() {
        return origins;
    }

    public void setOrigins(Set<Character> origins) {
        this.origins = origins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) &&
                Objects.equals(url, location.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, url);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                ", type='" + type + '\'' +
                ", dimension='" + dimension + '\'' +
                ", origins=" + origins +
                ", residents=" + residents +
                '}';
    }
}
