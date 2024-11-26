package com.cmd.service;

import com.cmd.entity.Bus;
import com.cmd.entity.BusStations;
import com.cmd.entity.Stations;
import com.cmd.repository.BusRepository;
import com.cmd.repository.BusStationsRepository;
import com.cmd.repository.StationRepository;
import org.springframework.stereotype.Service;

@Service
public class BusStationService {
    private BusStationsRepository busStationsRepository;
    private BusRepository busRepository;
    private StationRepository stationsRepository;

    public BusStationService(BusStationsRepository busStationsRepository, BusRepository busRepository, StationRepository stationsRepository) {
        this.busStationsRepository = busStationsRepository;
        this.busRepository = busRepository;
        this.stationsRepository = stationsRepository;
    }


    public void addBusDetails(BusStations bstations, long bid, long sid) {
        Bus bus = busRepository.findById(bid).get();
        Stations stations1 = stationsRepository.findById(sid).get();
        bstations.setBus(bus);
        bstations.setStations(stations1);
        busStationsRepository.save(bstations);


    }
}
