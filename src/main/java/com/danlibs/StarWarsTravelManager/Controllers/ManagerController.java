package com.danlibs.StarWarsTravelManager.Controllers;

import com.danlibs.StarWarsTravelManager.Models.TravelLog;
import com.danlibs.StarWarsTravelManager.Services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/travel_manager")
public class ManagerController {
    @Autowired
    private TravelService travelService;

    @GetMapping
    public List<TravelLog> showAllLogs() {
        return travelService.showLogs();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<TravelLog>> showLogById(@PathVariable("id") Integer travelLogId) {
        return ResponseEntity.ok(travelService.showLogById(travelLogId));
    }

    @PostMapping
    public ResponseEntity<TravelLog> travel(@RequestParam Integer pilotId, @RequestParam Integer starshipId, @RequestParam LocalDate travelDate) {
        return ResponseEntity.ok(travelService.travel(pilotId, starshipId, travelDate));
    }

    @PutMapping
    public ResponseEntity<TravelLog> arrive(@RequestParam Integer pilotId, @RequestParam LocalDate arriveDate) {
        return ResponseEntity.ok(travelService.arrive(pilotId, arriveDate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLog(@PathVariable("id") Integer travelLogId) {
        travelService.deleteLog(travelLogId);
        return new ResponseEntity<String>("Log" + travelLogId + "deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllLogs() {
        travelService.deleteAllLogs();
        return new ResponseEntity<String>("All logs deleted successfully", HttpStatus.OK);
    }
}
