package com.amazon.amazonagencyrestapitask.repository;

import com.amazon.amazonagencyrestapitask.entity.reports.Report;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends BaseRepository<Report> {

    @Query(value = "{ 'salesAndTrafficByDate' : { $elemMatch: { 'date' : ?0 } } }",
            fields = "{ 'salesAndTrafficByDate.$' : 1 }")
    List<Report> findBySalesAndTrafficByDate_Date(LocalDate date);

    @Query("{ 'salesAndTrafficByDate.date': { $gte: ?0, $lte: ?1 } }")
    List<Report> findReportsByDateRange(LocalDate start, LocalDate end);

    @Query(value = "{ 'salesAndTrafficByAsin' : { $elemMatch: { 'parentAsin' : ?0 } } }",
            fields = "{ 'salesAndTrafficByAsin.$' : 1 }")
    List<Report> findBySalesAndTrafficByAsin_Asin(String asin);

    @Query(value = "{}", fields = "{ 'salesAndTrafficByDate' : 1 }")
    List<Report> findAllBySalesAndTrafficByDate();

    @Query(value = "{}", fields = "{ 'salesAndTrafficByAsin' : 1 }")
    List<Report> findAllBySalesAndTrafficByAsin();
}
