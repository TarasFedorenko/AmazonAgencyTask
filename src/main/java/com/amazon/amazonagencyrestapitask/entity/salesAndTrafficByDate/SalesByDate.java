package com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByDate;

import com.amazon.amazonagencyrestapitask.entity.reports.CurrencyValue;
import lombok.Data;

import java.io.Serializable;

@Data
public class SalesByDate  implements Serializable {
    private CurrencyValue orderedProductSales;
    private CurrencyValue orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private CurrencyValue averageSalesPerOrderItem;
    private CurrencyValue averageSalesPerOrderItemB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private CurrencyValue averageSellingPrice;
    private CurrencyValue averageSellingPriceB2B;
    private int unitsRefunded;
    private double refundRate;
    private int claimsGranted;
    private CurrencyValue claimsAmount;
    private CurrencyValue shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;
}
