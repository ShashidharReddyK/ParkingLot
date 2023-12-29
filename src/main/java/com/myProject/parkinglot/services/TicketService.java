package com.myProject.parkinglot.services;

import com.myProject.parkinglot.exceptions.NoParkingSpotFoundException;
import com.myProject.parkinglot.models.*;
import com.myProject.parkinglot.strategies.SpotAssignmentStrategy;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(VehicleService vehicleService,GateService gateService,
                         SpotAssignmentStrategy spotAssignmentStrategy){
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotFoundException {

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }
        Gate gate = gateService.getGate(gateId);

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(System.currentTimeMillis());

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignParkingSpot(vehicleType,gate);

        if(parkingSpot == null){
            throw new NoParkingSpotFoundException("No Parking Spot found");
        }

        ticket.setParkingSpot(parkingSpot);

        return ticket;
    }
}
