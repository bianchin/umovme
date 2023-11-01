package me.umob.test.tickets.service;

import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class DiscountServiceTests {

    @Autowired
    DiscountService discountService;

    LocalDate date = LocalDate.of(2023,11, 3);


    @Test
    void errorMoreThan100() {
        assertThatThrownBy(() ->
                discountService.validateDiscountValue(100.1)
        ).isOfAnyClassIn(RuntimeException.class);
    }

    @Test
    void errorLessThan0() {
        assertThatThrownBy(() ->
                discountService.validateDiscountValue(-1d)
        ).isOfAnyClassIn(RuntimeException.class);
    }

    @Test
    void validateDiscountValue() {
        assertThat(discountService.validateDiscountValue(5d))
                .isEqualTo(5d);
    }



}
