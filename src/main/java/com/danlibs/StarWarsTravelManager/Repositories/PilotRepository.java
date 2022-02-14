package com.danlibs.StarWarsTravelManager.Repositories;

import com.danlibs.StarWarsTravelManager.Models.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {
}
