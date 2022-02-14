package com.danlibs.StarWarsTravelManager.Services;


import com.danlibs.StarWarsTravelManager.Models.TravelLog;

import java.time.LocalDate;

public interface TravelService {
    TravelLog travel(Integer pilotId, Integer starshipId, LocalDate travelDate);

    TravelLog arrive(Integer pilotId, LocalDate arriveDate);
}
