package me.umob.test.tickets.controller;

import me.umob.test.tickets.dto.Ticket;
import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TicketControllerTests {

    @Autowired
    TicketsController ticketsController;

    LocalDate date = LocalDate.of(2023,10, 30);



    @Test
    void ticketStudentCard() {
        Ticket ticket = Ticket
                .builder()
                .date(date)
                .type(TicketType.STUDENT)
                .category(TicketCategory.CARD)
                .normalPrice(8d)
                .discount(2.4d)
                .finalPrice(5.6d)
                .build();

        assertThat(ticketsController.get(date, TicketType.STUDENT, true))
                .usingRecursiveComparison()
                .isEqualTo(ticket);
    }

    @Test
    void ticketStudentDefault() {
        Ticket ticket = Ticket
                .builder()
                .date(date)
                .type(TicketType.STUDENT)
                .category(TicketCategory.ALL)
                .normalPrice(8d)
                .discount(0.8d)
                .finalPrice(7.2d)
                .build();

        assertThat(ticketsController.get(date, TicketType.STUDENT, false))
                .usingRecursiveComparison()
                .isEqualTo(ticket);
    }



}
