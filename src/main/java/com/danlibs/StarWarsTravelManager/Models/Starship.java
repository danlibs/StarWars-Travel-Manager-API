package com.danlibs.StarWarsTravelManager.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Starships")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Starship {
    @Id
    private Integer idStarship;
    @JsonProperty("name")
    private String name;
    @JsonProperty("model")
    private String model;
    @JsonProperty("starship_class")
    private String starshipClass;

    public Integer getIdStarship() {
        return idStarship;
    }

    public void setIdStarship(Integer idStarship) {
        this.idStarship = idStarship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }
}
