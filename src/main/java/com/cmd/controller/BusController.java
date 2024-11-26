package com.cmd.controller;

import com.cmd.entity.Bus;
import com.cmd.repository.BusRepository;
import com.cmd.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus/")
public class BusController {
    private BusService busService;
    private BusRepository busRepository;

    public BusController(BusService busService, BusRepository busRepository) {
        this.busService = busService;
        this.busRepository = busRepository;
    }

    //{{url}}/api/v1/bus/add
    @PostMapping("/add")
    public ResponseEntity<String> createBus(@RequestBody Bus name) {
        busService.createBus(name);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
