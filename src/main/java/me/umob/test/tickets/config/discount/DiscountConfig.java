package me.umob.test.tickets.config.discount;

import lombok.Getter;
import lombok.Setter;
import me.umob.test.tickets.dto.TicketCategory;

import java.util.Map;

@Getter
@Setter
public abstract class DiscountConfig {

    private Map<TicketCategory, Week> category;

}
