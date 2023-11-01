package me.umob.test.tickets.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Ticket {

    private LocalDate date;
    private TicketType type;
    private Double normalPrice;
    private Double discount;
    private Double finalPrice;

}
