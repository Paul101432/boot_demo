package com.sdtech.demo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryDicDto extends QueryDto {

    @ApiModelProperty(value = "字典键",example = "gender")
    String dictKey;

    @ApiModelProperty(value = "字典键描述",example = "性别")
    String dictKeyInfo;

    @ApiModelProperty(value = "字典值",example = "0")
    String dictVal;

    @ApiModelProperty(value = "字典值描述",example = "女")
    String dictValInfo;

}
