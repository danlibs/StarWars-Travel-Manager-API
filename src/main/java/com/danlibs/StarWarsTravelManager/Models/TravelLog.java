package com.danlibs.StarWarsTravelManager.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class TravelLog {
    @Id
    @GeneratedValue
    private Integer idTravelLog;
    @ManyToOne
    private Pilot pilot;
    @ManyToOne
    private Starship starship;
    private LocalDate arriveDate;
    private LocalDate travelDate;

    public Integer getIdTravelLog() {
        return idTravelLog;
    }

    public void setIdTravelLog(Integer idTravelLog) {
        this.idTravelLog = idTravelLog;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilotId) {
        this.pilot = pilotId;
    }

    public Starship getStarship() {
        return starship;
    }

    public void setStarship(Starship starshipId) {
        this.starship = starshipId;
    }

    public LocalDate getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalDate arriveDate) {
        this.arriveDate = arriveDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }
}
