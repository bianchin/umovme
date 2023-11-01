package me.umob.test.tickets.config;

import lombok.Getter;
import lombok.Setter;
import me.umob.test.tickets.dto.TicketType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "tickets")
@Setter
@Getter
public class TicketsConfig {

    private Map<TicketType, Double> prices;

}
