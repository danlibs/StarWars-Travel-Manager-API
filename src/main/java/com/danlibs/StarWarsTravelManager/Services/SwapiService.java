package com.danlibs.StarWarsTravelManager.Services;

import com.danlibs.StarWarsTravelManager.Models.Pilot;
import com.danlibs.StarWarsTravelManager.Models.Starship;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "swapi", url = "https://swapi.dev/api/")
public interface SwapiService {

    @GetMapping("/people/{id}")
    Pilot getPilot(@PathVariable("id") Integer id);

    @GetMapping("/starships/{id}")
    Starship getStarship(@PathVariable("id") Integer id);
}
