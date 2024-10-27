package com.amazon.amazonagencyrestapitask.entity.reports;

import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByAsin.SalesAndTrafficByAsin;
import com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByDate.SalesAndTrafficByDate;
import com.amazon.amazonagencyrestapitask.entity.user.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "reports")
@Data
public class Report extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
