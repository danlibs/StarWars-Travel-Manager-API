package com.danlibs.StarWarsTravelManager.Services;


import com.danlibs.StarWarsTravelManager.Models.TravelLog;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TravelService {
    TravelLog travel(Integer pilotId, Integer starshipId, LocalDate travelDate);

    TravelLog arrive(Integer pilotId, LocalDate arriveDate);

    List<TravelLog> showLogs();

    Optional<TravelLog> showLogById(Integer travelLogId);

    void deleteLog(Integer travelLogId);

    void deleteAllLogs();
}
