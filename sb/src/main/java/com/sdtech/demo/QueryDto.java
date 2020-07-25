package com.sdtech.demo;

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

    private String createTimeFrom;
    private String createTimeTo;

    //类型
    private Integer type;
    //排序依据
    private String sortField;
    //排序方式（递增/递减）
    private String sortOrder;

    public String getCreateTimeTo() {
        return createTimeTo+" 23:59:59";
    }
}
