package me.umob.test.tickets.service;

import me.umob.test.tickets.dto.Ticket;
import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TicketServiceTests {

    @Autowired
    TicketService ticketService;

    LocalDate date = LocalDate.of(2023,10, 30);

    @Test
    void studentPrice() {
        Ticket ticket = Ticket
                .builder()
                .date(date)
                .type(TicketType.STUDENT)
                .category(TicketCategory.ALL)
                .normalPrice(8d)
                .discount(0.8d)
                .finalPrice(7.2d)
                .build();

        assertThat(ticketService.get(date, TicketType.STUDENT, false))
                .usingRecursiveComparison()
                .isEqualTo(ticket);
    }

    @Test
    void seniorPrice() {
        Ticket ticket = Ticket
                .builder()
                .date(date)
                .type(TicketType.SENIOR)
                .category(TicketCategory.ALL)
                .normalPrice(6d)
                .discount(0.6d)
                .finalPrice(5.4d)
                .build();

        assertThat(ticketService.get(date, TicketType.SENIOR, false))
                .usingRecursiveComparison()
                .isEqualTo(ticket);
    }

    @Test
    void childrenPrice() {
        Ticket ticket = Ticket
                .builder()
                .date(date)
                .type(TicketType.CHILDREN)
                .category(TicketCategory.ALL)
                .normalPrice(5.5d)
                .discount(0.55d)
                .finalPrice(4.95d)
                .build();

        assertThat(ticketService.get(date, TicketType.CHILDREN, false))
                .usingRecursiveComparison()
                .isEqualTo(ticket);
    }

    @Test
    void ticketUnavailable() {
        assertThatThrownBy(() ->
            ticketService.get(date, TicketType.NORMAL, false)
        ).isOfAnyClassIn(RuntimeException.class);

    }



}
