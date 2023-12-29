package com.myProject.parkinglot.services;

import com.myProject.parkinglot.models.Gate;
import com.myProject.parkinglot.repositories.GateRepository;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }
    public Gate getGate(Long gateId){
        return gateRepository.getGateUsingGateId(gateId);
    }
}
