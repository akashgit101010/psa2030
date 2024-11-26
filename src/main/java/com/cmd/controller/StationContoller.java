package com.cmd.controller;

import com.cmd.entity.Stations;
import com.cmd.repository.StationRepository;
import com.cmd.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/station/")
public class StationContoller {
    private StationService stationService;
    private StationRepository stationRepository;

    public StationContoller(StationService stationService, StationRepository stationRepository) {
        this.stationRepository = stationRepository;
        this.stationService = stationService;

    }

    //{{url}}/api/v1/stations/add
    @PostMapping("/add")
    public ResponseEntity<String> addStation(@RequestBody Stations s) {
        stationService.addBusName(s);
        return new ResponseEntity<String>("success", HttpStatus.CREATED);
    }

}
