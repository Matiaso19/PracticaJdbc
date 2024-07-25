package com.SoyHenry.PracticaJdbcTemplate.service;

import com.SoyHenry.PracticaJdbcTemplate.model.Ticket;
import com.SoyHenry.PracticaJdbcTemplate.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.getAllTickets();
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.insertTicket(ticket);
    }




}
