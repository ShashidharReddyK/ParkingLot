package com.myProject.parkinglot.strategies;

import com.myProject.parkinglot.models.*;
import com.myProject.parkinglot.services.ParkingLotService;
import com.myProject.parkinglot.services.ParkingSpotService;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;

    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService,ParkingSpotService parkingSpotService){
        this.parkingLotService = parkingLotService;
        this.parkingSpotService = parkingSpotService;
    }
    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate){

        ParkingLot parkingLot = parkingLotService.getParkingLotByGate(gate);

        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpotsByLot(parkingLot);

        for(ParkingSpot parkingSpot:parkingSpots){
            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
            parkingSpot.getSupportedVehicleTypes().contains(vehicleType)){
                return parkingSpot;
            }
        }
        return null;
    }
}
