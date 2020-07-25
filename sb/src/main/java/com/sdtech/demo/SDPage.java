package com.sdtech.demo;

import com.jfinal.plugin.activerecord.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "分页对象")
public class SDPage<T> extends Page {

    @ApiModelProperty("分页数据")
    private List<T> list;				// list result of this page

    @ApiModelProperty("当前页码")
    private int pageNumber;				// page number

    @ApiModelProperty("每页记录数")
    private int pageSize;				// result amount of this page

    @ApiModelProperty("总页数")
    private int totalPage;				// total page

    @ApiModelProperty("总记录数")
    private int totalRow;				// total row


    @ApiModelProperty("是否第一页")
    private boolean firstPage;				// total row


    @ApiModelProperty("是否最后一页")
    private boolean lastPage;				// total row



}
