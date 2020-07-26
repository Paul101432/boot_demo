package com.sdtech.demo.swagger;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用表格查询条件传输对象  TODO 临时
 */
@Data
public class QueryDto implements Serializable {

    private int pageSize = 10;
    private int pageNum = 1;

    private String name;

    private String createTimeFrom;// 创建开始时间
    private String createTimeTo;// 创建结束时间


    private Integer type;//类型

    private String sortField;//排序依据

    private String sortOrder;  //排序方式（递增/递减）

    public String getCreateTimeTo() {
        return createTimeTo+" 23:59:59";
    }
}
