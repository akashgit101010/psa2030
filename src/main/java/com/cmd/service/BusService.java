package com.cmd.service;

import com.cmd.entity.Bus;
import com.cmd.repository.BusRepository;
import org.springframework.stereotype.Service;

@Service
public class BusService {
    private BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public void createBus(Bus name) {
        busRepository.save(name);
    }


}
