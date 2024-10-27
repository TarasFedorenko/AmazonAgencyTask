package com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByDate;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class SalesAndTrafficByDate implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate date;
    private SalesByDate salesByDate;
    private SalesByTraffic trafficByDate;
}
