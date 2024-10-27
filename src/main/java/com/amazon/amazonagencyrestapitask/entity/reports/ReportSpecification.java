package com.amazon.amazonagencyrestapitask.entity.reports;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReportSpecification implements Serializable {
    private String reportType;
    private ReportOptions reportOptions;
    private String dataStartTime;
    private String dataEndTime;
    private List<String> marketplaceIds;

}
