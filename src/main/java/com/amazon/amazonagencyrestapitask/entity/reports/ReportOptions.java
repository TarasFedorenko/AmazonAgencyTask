package com.amazon.amazonagencyrestapitask.entity.reports;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportOptions implements Serializable {
    private String dateGranularity;
    private String asinGranularity;
}
