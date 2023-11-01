package me.umob.test.tickets.config.discount;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("STUDENTdiscountConfig")
@ConfigurationProperties(prefix = "discount.student")
public class StudentDiscountConfig extends DiscountConfig {
}
