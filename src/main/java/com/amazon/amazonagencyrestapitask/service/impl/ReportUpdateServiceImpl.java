package com.amazon.amazonagencyrestapitask.service.impl;

import com.amazon.amazonagencyrestapitask.entity.reports.Report;
import com.amazon.amazonagencyrestapitask.service.ReportService;
import com.amazon.amazonagencyrestapitask.service.ReportUpdateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ReportUpdateServiceImpl implements ReportUpdateService {
    private final ObjectMapper objectMapper;
    private final ReportService reportService;
    private static final String JSON_FILE_PATH = "src/main/resources/test_report.json";

    public ReportUpdateServiceImpl(ObjectMapper objectMapper, ReportService reportService) {
        this.objectMapper = objectMapper;
        this.reportService = reportService;
    }

    @Override
    public void startUpdate() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(JSON_FILE_PATH));
            Report report = objectMapper.readValue(jsonData, Report.class);
            reportService.updateReport(report);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Scheduled(fixedRate = 30000)
    void updateSchedule() {
        System.out.println("update reports every 30 seconds");
        startUpdate();
    }


}