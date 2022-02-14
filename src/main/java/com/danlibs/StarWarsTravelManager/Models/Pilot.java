package com.danlibs.StarWarsTravelManager.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pilots")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pilot {
    @Id
    private Integer idPilot;
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    @JsonProperty("birth_year")
    private String birthYear;
    @NotNull
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
}
