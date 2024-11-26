package com.cmd.controller;

import com.cmd.entity.BusStations;
import com.cmd.repository.BusStationsRepository;
import com.cmd.service.BusStationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/control/")
public class BusStationController {

    private BusStationService busStationService;
    private BusStationsRepository busStationsRepository;

    public BusStationController(BusStationService busStationService, BusStationsRepository busStationsRepository) {
        this.busStationService = busStationService;
        this.busStationsRepository = busStationsRepository;
    }
//{{url}}/api/v1/control/add/1/2
    @PostMapping("/add/{bid}/{sid}")
    public ResponseEntity<String> addBusDetail(@RequestBody BusStations bstations, @PathVariable long bid , @PathVariable long sid) {
        busStationService.addBusDetails(bstations, bid , sid);
        return new ResponseEntity<>("Added Busdetails", HttpStatus.CREATED);

    }


}
