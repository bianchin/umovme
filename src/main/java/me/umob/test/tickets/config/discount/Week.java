package me.umob.test.tickets.config.discount;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.Map;

@Getter
@Setter
public class Week {

    private Map<DayOfWeek, Double> days;

    private Double holiday;

}
