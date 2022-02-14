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
import java.util.ArrayList;
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
        Pilot pilot = swapiService.getPilot(pilotId);
        Starship starship = swapiService.getStarship(starshipId);
        List<Integer> spaceshipIdsPilot = new ArrayList<>();
        for (String id : pilot.getStarships()) {
            String stringFormat = id.split("/")[5];
            spaceshipIdsPilot.add(Integer.parseInt(stringFormat));
        }
        pilot.setIdPilot(pilotId);
        starship.setIdStarship(starshipId);
        if (!starshipRepository.existsById(starshipId))
            starshipRepository.save(starship);
        if (pilotRepository.existsById(pilotId)) {
            if (!pilotRepository.findById(pilotId).get().isAway()) {
                checkPilotSpaceshipSave(spaceshipIdsPilot, starship, pilot);
                return getTravelLog(travelDate, pilot, starship);
            } else {
                // FIXME - What happens if pilot is away
                return null;
            }
        } else {
            checkPilotSpaceshipSave(spaceshipIdsPilot, starship, pilot);
            return getTravelLog(travelDate, pilot, starship);
        }
    }

    @Override
    public TravelLog arrive(Integer pilotId, LocalDate arriveDate) {
        if (pilotRepository.existsById(pilotId)) {
            Optional<Pilot> pilot = pilotRepository.findById(pilotId);
            if (pilot.get().isAway()) {
                TravelLog travelLog = new TravelLog();
                pilot.get().setAway(false);
                pilotRepository.save(pilot.get());
                List<TravelLog> logs = travelLogRepository.findAll();
                Collections.reverse(logs);
                for (TravelLog log : logs) {
                    if (log.getTravelDate().isBefore(arriveDate)) {
                        if (log.getPilot().getIdPilot().equals(pilot.get().getIdPilot())) {
                            log.setArriveDate(arriveDate);
                            travelLog = log;
                            break;
                        }
                    } else return null;
                }
                travelLogRepository.save(travelLog);
                return travelLog;
            } else {
                // FIXME - E se o piloto não tiver saído em viagem?
                return null;
            }
        }
        return null;
    }

    @Override
    public List<TravelLog> showLogs() {
        return travelLogRepository.findAll();
    }

    @Override
    public Optional<TravelLog> showLogById(Integer travelLogId) {
        return travelLogRepository.findById(travelLogId);
    }

    @Override
    public void deleteLog(Integer travelLogId) {
        travelLogRepository.deleteById(travelLogId);
    }

    @Override
    public void deleteAllLogs() {
        travelLogRepository.deleteAll();
    }

    private void checkPilotSpaceshipSave(List<Integer> spaceshipIdsPilot, Starship starship, Pilot pilot) {
        for (Integer id : spaceshipIdsPilot) {
            if (id.equals(starship.getIdStarship())) {
                pilot.setAway(true);
                pilotRepository.save(pilot);
                break;
            }
        }
    }

    private TravelLog getTravelLog(LocalDate travelDate, Pilot pilot, Starship starship) {
        TravelLog travelLog = new TravelLog();
        travelLog.setTravelDate(travelDate);
        travelLog.setPilot(pilot);
        travelLog.setStarship(starship);
        travelLogRepository.save(travelLog);
        return travelLog;
    }

}

