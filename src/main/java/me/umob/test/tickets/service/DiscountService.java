package me.umob.test.tickets.service;

import me.umob.test.tickets.config.discount.ConfigFactoryService;
import me.umob.test.tickets.config.discount.Week;
import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    ConfigFactoryService configFactoryService;

    @Autowired
    HolidayService holidayService;

    Logger logger = LoggerFactory.getLogger(DiscountService.class);

    public Double get(LocalDate date, TicketType ticketType, TicketCategory ticketCategory) {
        boolean isHoliday = holidayService.isHoliday(date);

        return configFactoryService
                .getConfig(ticketType)
                .getCategory()
                .entrySet()
                .stream()
                .filter(ticketCategoryWeekEntry ->  Arrays.asList(TicketCategory.ALL, ticketCategory).contains( ticketCategoryWeekEntry.getKey() )  )
                .map(Map.Entry::getValue)
                .map(week -> getDayDiscount(week, date, isHoliday))
                .max(Comparator.naturalOrder())
                .orElse(0d);

    }

    private Double getDayDiscount(Week week, LocalDate date, boolean isHoliday) {
        Double discount = isHoliday ? week.getHoliday() : week.getDays().get(date.getDayOfWeek());
        logger.info("discount: " + discount);
        return Optional.ofNullable(discount).map(this::validateDiscountValue).orElse(0d);

    }

    Double validateDiscountValue(Double value) {
        if(value<0||value>100) {
            throw new RuntimeException("Invalid discount");
        }
        return value;
    }



}
