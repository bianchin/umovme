package me.umob.test.tickets.service;

import me.umob.test.tickets.dto.TicketCategory;
import me.umob.test.tickets.dto.TicketType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HolidayServiceTests {

    @Autowired
    HolidayService holidayService;

    LocalDate holiday = LocalDate.of(2023,12, 25);

    LocalDate notHoliday = LocalDate.of(2023,11, 3);

    @Test
    void isHoliday() {
        assertThat(holidayService.isHoliday(holiday))
                .isTrue();
    }

    @Test
    void isNotHoliday() {
        assertThat(holidayService.isHoliday(notHoliday))
                .isFalse();
    }




}
