package com.myProject.parkinglot.dto;

import com.myProject.parkinglot.models.ResponseStatus;
import com.myProject.parkinglot.models.Ticket;

public class GenerateTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
