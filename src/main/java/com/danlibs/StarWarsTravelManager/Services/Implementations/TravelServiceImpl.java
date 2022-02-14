package com.danlibs.StarWarsTravelManager.Services.Implementations;

import com.danlibs.StarWarsTravelManager.Models.Pilot;
import com.danlibs.StarWarsTravelManager.Models.Starship;
import com.danlibs.StarWarsTravelManager.Models.TravelLog;
import com.danlibs.StarWarsTravelManager.Repositories.PilotRepository;
import com.danlibs.StarWarsTravelManager.Repositories.StarshipRepository;
import com.danlibs.StarWarsTravelManager.Repositories.TravelLogRepository;
import com.danlibs.StarWarsTravelManager.Services.SwapiService;
import com.danlibs.StarWarsTravelManager.Services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {
    @Autowired
    private SwapiService swapiService;
    @Autowired
    private PilotRepository pilotRepository;
    @Autowired
    private StarshipRepository starshipRepository;
    @Autowired
    private TravelLogRepository travelLogRepository;


    @Override
    public TravelLog travel(Integer pilotId, Integer starshipId, LocalDate travelDate) {
        // FIXME - e se não existir piloto ou nave na API?
        // FIXME - um piloto pode pilotar qualquer nave? Deve seguir a API
        Pilot pilot = swapiService.getPilot(pilotId);
        pilot.setIdPilot(pilotId);
        Starship starship = swapiService.getStarship(starshipId);
        starship.setIdStarship(starshipId);
        if (!starshipRepository.existsById(starshipId))
            starshipRepository.save(starship);
        if (pilotRepository.existsById(pilotId)) {
            if (!pilotRepository.findById(pilotId).get().isAway()) {
                pilot.setAway(true);
                pilotRepository.save(pilot);
                return getTravelLog(travelDate, pilot, starship);
            } else {
                // FIXME - E se o piloto já estiver de viagem?
                return null;
            }
        } else {
            pilot.setAway(true);
            pilotRepository.save(pilot);
            return getTravelLog(travelDate, pilot, starship);
        }
    }

    @Override
    public TravelLog arrive(Integer pilotId, LocalDate arriveDate) {
        //FIXME - E se o piloto informado não estiver no banco?
        if (pilotRepository.existsById(pilotId)) {
            Optional<Pilot> pilot = pilotRepository.findById(pilotId);
            if (pilot.get().isAway()) {
                TravelLog travelLog = new TravelLog();
                pilot.get().setAway(false);
                pilotRepository.save(pilot.get());
                List<TravelLog> logs = travelLogRepository.findAll();
                Collections.reverse(logs);
                for (TravelLog log : logs) {
                    if (log.getPilotId().equals(pilot.get().getIdPilot())) {
                        log.setArriveDate(arriveDate);
                        travelLog = log;
                        break;
                    }
                }
                travelLogRepository.save(travelLog);
                return travelLog;
            } else {
                // FIXME - E se o piloto não tiver saído em viagem?
                System.out.println("This pilot is already here!");
            }
        }
        return null;
    }

    private TravelLog getTravelLog(LocalDate travelDate, Pilot pilot, Starship starship) {
        TravelLog travelLog = new TravelLog();
        travelLog.setTravelDate(travelDate);
        travelLog.setPilotId(pilot.getIdPilot());
        travelLog.setStarshipId(starship.getIdStarship());
        travelLogRepository.save(travelLog);
        return travelLog;
    }

}

