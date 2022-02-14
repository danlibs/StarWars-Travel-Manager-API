package com.danlibs.StarWarsTravelManager.Repositories;

import com.danlibs.StarWarsTravelManager.Models.Starship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarshipRepository extends JpaRepository<Starship, Integer> {
}
