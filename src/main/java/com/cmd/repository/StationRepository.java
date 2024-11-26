package com.cmd.repository;

import com.cmd.entity.Stations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Stations, Long> {
}