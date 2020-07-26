package com.sdtech.demo.smart_doc;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class BaseRespDto {

    @ApiModelProperty(value = "是否系统默认,0 否 1 是",example = "1")
    int isSys;// 是否系统默认

    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @ApiModelProperty(value = "创建时间",example = "2020-02-02 00:00:00")
    Date createDt;//创建时间

    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @ApiModelProperty(value = "修改时间",example = "2020-02-02 00:00:00")
    Date updateDt;//修改时间

}
