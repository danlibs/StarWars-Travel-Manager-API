package com.danlibs.StarWarsTravelManager.Repositories;

import com.danlibs.StarWarsTravelManager.Models.TravelLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelLogRepository extends JpaRepository<TravelLog, Integer> {
}
