package com.myProject.parkinglot;

import com.myProject.parkinglot.controllers.TicketController;
import com.myProject.parkinglot.dto.GenerateTicketRequestDto;
import com.myProject.parkinglot.dto.GenerateTicketResponseDto;
import com.myProject.parkinglot.models.Ticket;
import com.myProject.parkinglot.models.VehicleType;
import com.myProject.parkinglot.repositories.GateRepository;
import com.myProject.parkinglot.repositories.ParkingLotRepository;
import com.myProject.parkinglot.repositories.ParkingSpotRepository;
import com.myProject.parkinglot.repositories.VehicleRepository;
import com.myProject.parkinglot.services.*;
import com.myProject.parkinglot.strategies.RandomSpotAssignmentStrategy;
import com.myProject.parkinglot.strategies.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        ObjectContainer objectContainer = new ObjectContainer();
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        GateRepository gateRepository = new GateRepository();
        GateService gateService = new GateService(gateRepository);
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotService,parkingSpotService);
        TicketService ticketService = new TicketService(vehicleService,gateService,spotAssignmentStrategy);
        TicketController ticketController = new TicketController(ticketService);


        objectContainer.register("vehicleRepository",vehicleRepository);
        objectContainer.register("vehicleService",vehicleService);
        objectContainer.register("gateRepository",gateRepository);
        objectContainer.register("gateService",gateService);
        objectContainer.register("parkingSpotRepository",parkingSpotRepository);
        objectContainer.register("parkingLotRepository",parkingLotRepository);
        objectContainer.register("parkingSpotService",parkingSpotService);
        objectContainer.register("parkingLotService",parkingLotService);
        objectContainer.register("spotAssignmentStrategy",spotAssignmentStrategy);
        objectContainer.register("ticketService",ticketService);

        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setVehicleType(VehicleType.SUV);
        requestDto.setVehicleNumber("TS05S9395");

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);
        Ticket ticket = responseDto.getTicket();

//        System.out.println("Hello world!");
    }
}