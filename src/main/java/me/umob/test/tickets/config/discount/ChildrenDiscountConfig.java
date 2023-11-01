package me.umob.test.tickets.config.discount;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("CHILDRENdiscountConfig")
@ConfigurationProperties(prefix = "discount.children")
public class ChildrenDiscountConfig extends DiscountConfig {
}
