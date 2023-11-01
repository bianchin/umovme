package me.umob.test.tickets.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "holidays")
@Setter
@Getter
public class HolidaysConfig {

    private List<LocalDate> days;

}
