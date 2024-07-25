package com.SoyHenry.PracticaJdbcTemplate.controller;

import com.SoyHenry.PracticaJdbcTemplate.model.Ticket;
import com.SoyHenry.PracticaJdbcTemplate.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;




    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets(){
       List<Ticket> tickets = ticketService.getAllTickets();
       return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        Ticket newTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }


}
