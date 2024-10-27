package com.amazon.amazonagencyrestapitask.service;

import com.amazon.amazonagencyrestapitask.entity.reports.Report;
import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByAsin.SalesAndTrafficByAsin;
import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByDate.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    SalesAndTrafficByDate findByDate(LocalDate date);

    List<SalesAndTrafficByDate> findByDates(LocalDate start, LocalDate end);

    SalesAndTrafficByAsin findByAsin(String asin);

    List<SalesAndTrafficByDate> findAllBySalesAndTrafficByDate();

    List<SalesAndTrafficByAsin> findAllBySalesAndTrafficByAsin();

    void updateReport(Report report);


}
