package com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByAsin;

import com.amazon.amazonagencyrestapitask.entity.reports.CurrencyValue;
import lombok.Data;

import java.io.Serializable;

@Data
public class SalesByAsin implements Serializable {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private CurrencyValue orderedProductSales;
    private CurrencyValue orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
}
