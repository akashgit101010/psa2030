package com.cmd.repository;

import com.cmd.entity.BusStations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStationsRepository extends JpaRepository<BusStations, Long> {
}