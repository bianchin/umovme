package me.umob.test.tickets.config.discount;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("SENIORdiscountConfig")
@ConfigurationProperties(prefix = "discount.senior")
public class SeniorDiscountConfig extends DiscountConfig {
}
