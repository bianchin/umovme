package me.umob.test.tickets.controller;

import me.umob.test.tickets.dto.Ticket;
import me.umob.test.tickets.dto.TicketType;
import me.umob.test.tickets.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class TicketsController {

    @Autowired
    TicketService ticketService;

    Logger logger = LoggerFactory.getLogger(TicketsController.class);

    @GetMapping("/tickets")
    public @ResponseBody Ticket get(@RequestParam LocalDate date, @RequestParam TicketType type, @RequestParam(required = false) boolean hasCard) {
        logger.info("calling ticket {} {} {} ", date, type, hasCard);
        return ticketService.get(date, type, hasCard);
    }


}
