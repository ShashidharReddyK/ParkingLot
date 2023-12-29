package com.myProject.parkinglot.services;

import com.myProject.parkinglot.models.Gate;
import com.myProject.parkinglot.models.ParkingLot;
import com.myProject.parkinglot.repositories.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    public ParkingLot getParkingLotByGate(Gate gate){
        return parkingLotRepository.getParkingLotusingId(gate);
    }
}
