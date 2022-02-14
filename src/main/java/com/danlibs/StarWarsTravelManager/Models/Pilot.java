package com.danlibs.StarWarsTravelManager.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Pilots")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pilot {
    @Id
    private Integer idPilot;
    @JsonProperty("name")
    private String name;
    @JsonProperty("birth_year")
    private String birthYear;
    @ElementCollection
    @JsonProperty("starships")
    private List<String> starships;
    private boolean isAway = false;

    public Integer getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(Integer id) {
        this.idPilot = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isAway() {
        return isAway;
    }

    public void setAway(boolean away) {
        isAway = away;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }
}
