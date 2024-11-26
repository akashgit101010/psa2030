package com.cmd.service;

import com.cmd.entity.Stations;
import com.cmd.repository.StationRepository;
import org.springframework.stereotype.Service;

@Service
public class StationService {
    private StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void addBusName(Stations name) {
         stationRepository.save(name);
    }
}
