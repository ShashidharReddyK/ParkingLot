package com.myProject.parkinglot.services;

import com.myProject.parkinglot.models.ParkingLot;
import com.myProject.parkinglot.models.ParkingSpot;
import com.myProject.parkinglot.repositories.ParkingSpotRepository;

import java.util.List;

public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
    public List<ParkingSpot> getParkingSpotsByLot(ParkingLot parkingLot){
        return parkingSpotRepository.getParkingSpot(parkingLot);
    }
}
