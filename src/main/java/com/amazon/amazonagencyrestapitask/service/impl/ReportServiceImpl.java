package com.amazon.amazonagencyrestapitask.service.impl;

import com.amazon.amazonagencyrestapitask.entity.reports.Report;
import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByAsin.SalesAndTrafficByAsin;
import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByDate.SalesAndTrafficByDate;
import com.amazon.amazonagencyrestapitask.repository.ReportRepository;
import com.amazon.amazonagencyrestapitask.service.ReportService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Cacheable(value = "reportsByDate")
    @Override
    public SalesAndTrafficByDate findByDate(LocalDate date) {
        List<Report> reports = reportRepository.findBySalesAndTrafficByDate_Date(date);
        if (reports.size() == 0 || reports.get(0).getSalesAndTrafficByDate().size() == 0)
            throw new RuntimeException("Date not found");
        return reports.get(0).getSalesAndTrafficByDate().get(0);
    }

    @Cacheable(value = "reportsByDates")
    @Override
    public List<SalesAndTrafficByDate> findByDates(LocalDate start, LocalDate end) {
        return reportRepository.findReportsByDateRange(start, end).stream()
                .flatMap(report -> report.getSalesAndTrafficByDate().stream())
                .filter(entry -> !entry.getDate().isBefore(start) && !entry.getDate().isAfter(end))
                .collect(Collectors.toList());
    }

    @Cacheable(value = "reportsByAsin")
    @Override
    public SalesAndTrafficByAsin findByAsin(String asin) {
        List<Report> reports = reportRepository.findBySalesAndTrafficByAsin_Asin(asin);
        if (reports.size() == 0 || reports.get(0).getSalesAndTrafficByAsin().size() == 0)
            throw new RuntimeException("Asin not found");
        return reports.get(0).getSalesAndTrafficByAsin().get(0);
    }

    @Cacheable(value = "allReportsByDate")
    @Override
    public List<SalesAndTrafficByDate> findAllBySalesAndTrafficByDate() {
        return reportRepository.findAllBySalesAndTrafficByDate().stream()
                .flatMap(report -> report.getSalesAndTrafficByDate().stream())
                .collect(Collectors.toList());
    }

    @Cacheable(value = "allReportsByAsin")
    @Override
    public List<SalesAndTrafficByAsin> findAllBySalesAndTrafficByAsin() {
        return reportRepository.findAllBySalesAndTrafficByAsin().stream()
                .flatMap(report -> report.getSalesAndTrafficByAsin().stream())
                .collect(Collectors.toList());
    }

    @Override
    @CacheEvict(value = {"reportsByDate", "reportsByDates", "reportsByAsin", "allReportsByDate", "allReportsByAsin"}, allEntries = true)
    public void updateReport(Report report) {
        Report oldReport = reportRepository.findAll().stream().findFirst().orElse(null);
        if (oldReport != null) {
            oldReport.setReportSpecification(report.getReportSpecification());
            oldReport.setSalesAndTrafficByDate(report.getSalesAndTrafficByDate());
            oldReport.setSalesAndTrafficByAsin(report.getSalesAndTrafficByAsin());
            reportRepository.save(oldReport);
        } else {
            reportRepository.save(report);
        }
    }
}
