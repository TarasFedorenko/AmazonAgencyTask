package com.amazon.amazonagencyrestapitask.entity.reports;

import lombok.Data;

import java.io.Serializable;

@Data
public class CurrencyValue implements Serializable {
    private double amount;
    private String currencyCode;
}
