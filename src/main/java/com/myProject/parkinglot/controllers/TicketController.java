package com.myProject.parkinglot.controllers;

import com.myProject.parkinglot.dto.GenerateTicketRequestDto;
import com.myProject.parkinglot.dto.GenerateTicketResponseDto;
import com.myProject.parkinglot.exceptions.NoParkingSpotFoundException;
import com.myProject.parkinglot.models.Gate;
import com.myProject.parkinglot.models.ResponseStatus;
import com.myProject.parkinglot.models.Ticket;
import com.myProject.parkinglot.models.Vehicle;
import com.myProject.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        // get the vehicle details from the DB
        // if the vehicle is there fetch the details else create the vehicle and store it in DB
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try{
            Ticket ticket  = ticketService.generateTicket(requestDto.getVehicleNumber(),
                    requestDto.getVehicleType(), requestDto.getGateId());

            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(NoParkingSpotFoundException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

//        generateTicketResponseDto.setResponseStatus();

        return responseDto;
    }
}
