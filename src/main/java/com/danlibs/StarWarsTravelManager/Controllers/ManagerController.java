package com.danlibs.StarWarsTravelManager.Controllers;

import com.danlibs.StarWarsTravelManager.Models.TravelLog;
import com.danlibs.StarWarsTravelManager.Services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/travel_manager")
public class ManagerController {
    @Autowired
    private TravelService travelService;

    @PostMapping
    public ResponseEntity<TravelLog> travel(@RequestParam Integer pilotId, @RequestParam Integer starshipId, @RequestParam LocalDate travelDate) {
        return ResponseEntity.ok(travelService.travel(pilotId, starshipId, travelDate));
    }

    @PutMapping
    public ResponseEntity<TravelLog> arrive(@RequestParam Integer pilotId, @RequestParam LocalDate arriveDate) {
        return ResponseEntity.ok(travelService.arrive(pilotId, arriveDate));
    }
}
