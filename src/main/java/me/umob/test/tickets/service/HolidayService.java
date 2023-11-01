package me.umob.test.tickets.service;

import me.umob.test.tickets.config.HolidaysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HolidayService {

    @Autowired
    HolidaysConfig holidaysConfig;

    public boolean isHoliday(LocalDate date) {
        return holidaysConfig.getDays().contains(date);
    }

}
