package com.danlibs.StarWarsTravelManager.Models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@Entity
public class TravelLog {
    @Id
    @GeneratedValue
    private Integer idTravelLog;
    private Integer pilotId;
    private Integer starshipId;
    private LocalDate arriveDate;
    private LocalDate travelDate;

    public Integer getIdTravelLog() {
        return idTravelLog;
    }

    public void setIdTravelLog(Integer idTravelLog) {
        this.idTravelLog = idTravelLog;
    }

    public Integer getPilotId() {
        return pilotId;
    }

    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public Integer getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(Integer starshipId) {
        this.starshipId = starshipId;
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
