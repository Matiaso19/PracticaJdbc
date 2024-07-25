package com.SoyHenry.PracticaJdbcTemplate.service;

import com.SoyHenry.PracticaJdbcTemplate.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    List<Ticket> getAllTickets();
    Ticket createTicket(Ticket ticket);

}
