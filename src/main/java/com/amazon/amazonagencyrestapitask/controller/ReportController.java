package com.amazon.amazonagencyrestapitask.controller;

import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByAsin.SalesAndTrafficByAsin;
import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByDate.SalesAndTrafficByDate;
import com.amazon.amazonagencyrestapitask.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping("/date/{date}")
    public ResponseEntity<SalesAndTrafficByDate> findByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.ok(reportService.findByDate(date));
    }
    @GetMapping("/date/{start}/{end}")
    public ResponseEntity<List<SalesAndTrafficByDate>> findByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate start,
                                                                   @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
        return ResponseEntity.ok(reportService.findByDates(start, end));
    }
    @GetMapping("/asin/{asin}")
    public ResponseEntity<SalesAndTrafficByAsin> findByAsin(@PathVariable String asin) {
        return ResponseEntity.ok(reportService.findByAsin(asin));
    }
    @GetMapping("/dates")
    public ResponseEntity<List<SalesAndTrafficByDate>> findAllBySalesAndTrafficByDate() {
        return ResponseEntity.ok(reportService.findAllBySalesAndTrafficByDate());
    }
    @GetMapping("/asins")
    public ResponseEntity<List<SalesAndTrafficByAsin>> findAllBySalesAndTrafficByAsin() {
        return ResponseEntity.ok(reportService.findAllBySalesAndTrafficByAsin());
    }
}
