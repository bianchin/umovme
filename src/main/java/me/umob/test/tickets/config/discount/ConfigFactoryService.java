package me.umob.test.tickets.config.discount;

import me.umob.test.tickets.config.discount.DiscountConfig;
import me.umob.test.tickets.dto.TicketType;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigFactoryService {

    private static final String CONFIG_NAME_SUFFIX = "discountConfig";
    private final BeanFactory beanFactory;

    @Autowired
    public ConfigFactoryService(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public DiscountConfig getConfig(TicketType ticketType) {
        return beanFactory.getBean(getRegionServiceBeanName(ticketType),
                DiscountConfig.class);
    }

    private String getRegionServiceBeanName(TicketType ticketType) {
        return ticketType + CONFIG_NAME_SUFFIX;
    }

}
