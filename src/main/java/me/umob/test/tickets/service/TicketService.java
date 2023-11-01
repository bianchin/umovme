package me.umob.test.tickets.service;

import me.umob.test.tickets.config.TicketsConfig;
import me.umob.test.tickets.dto.Ticket;
import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketsConfig ticketsConfig;

    @Autowired
    DiscountService discountService;

    Logger logger = LoggerFactory.getLogger(TicketService.class);

    public Ticket get(LocalDate date, TicketType ticketType, boolean hasCard) {

        Double price = ticketsConfig.getPrices().get(ticketType);
        Optional.ofNullable(price).orElseThrow(() -> new RuntimeException("Ticket unavailable"));
        Double totalDiscount = calcTotalDiscount(
                price,
                discountService.get(date, ticketType, getCategory(ticketType, hasCard)));

        return Ticket
                .builder()
                .date(date)
                .type(ticketType)
                .normalPrice(price)
                .discount(totalDiscount)
                .finalPrice(price - totalDiscount)
                .build();

    }

    private Double calcTotalDiscount(Double price, Double discount){
        return BigDecimal.valueOf(price * getFactor(discount))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
    private Double getFactor(Double discount) {
        return 1 - ((100-discount)/100);
    }

    private TicketCategory getCategory(TicketType ticketType, boolean hasCard) {
        if (TicketType.STUDENT.equals(ticketType) && hasCard){
            return TicketCategory.CARD;
        }
        return TicketCategory.ALL;
    }



}
