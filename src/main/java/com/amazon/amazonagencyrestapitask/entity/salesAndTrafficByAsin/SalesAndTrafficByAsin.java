package com.amazon.amazonagencyrestapitask.entity.salesAndTrafficByAsin;

import com.amazon.amazonagencyrestapitask.entity.user.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class SalesAndTrafficByAsin  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
