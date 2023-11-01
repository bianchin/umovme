package me.umob.test.tickets.service;

import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SundayDiscountServiceTests {

    @Autowired
    DiscountService discountService;

    LocalDate date = LocalDate.of(2023,11, 5);

    @Test
    void discountStudent() {
        assertThat(discountService.get(date, TicketType.STUDENT, TicketCategory.ALL))
                .isEqualTo(0d);
    }

    @Test
    void discountStudentWithCardCard() {
        assertThat(discountService.get(date, TicketType.STUDENT, TicketCategory.CARD))
                .isEqualTo(0d);
    }

    @Test
    void discountSenior() {
        assertThat(discountService.get(date, TicketType.SENIOR, TicketCategory.ALL))
                .isEqualTo(5d);
    }

    @Test
    void discountChindrenOK() {
        assertThat(discountService.get(date, TicketType.CHILDREN, TicketCategory.ALL))
                .isEqualTo(0d);
    }





}
