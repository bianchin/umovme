package me.umob.test.tickets.controller;

import me.umob.test.tickets.dto.Ticket;
import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import me.umob.test.tickets.service.DiscountService;
import me.umob.test.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class TicketsController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public @ResponseBody Ticket get(@RequestParam LocalDate date, @RequestParam TicketType type, @RequestParam(required = false) boolean hasCard) {
        return ticketService.get(date, type, hasCard);
    }


}
