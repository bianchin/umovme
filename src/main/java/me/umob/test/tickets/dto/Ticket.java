package me.umob.test.tickets.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class Ticket {

    private LocalDate date;
    private TicketType type;
    private TicketCategory category;
    private Double normalPrice;
    private Double discount;
    private Double finalPrice;

}
