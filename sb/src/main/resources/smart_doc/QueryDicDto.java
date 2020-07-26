package com.sdtech.demo.smart_doc;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 字典返回值
 */
@Data
public class QueryDicDto extends QueryDto {

    @ApiModelProperty(value = "字典键",example = "gender")
    String dictKey;//字典键

    @ApiModelProperty(value = "字典键描述",example = "性别")
    String dictKeyInfo;//字典键描述

    @ApiModelProperty(value = "字典值",example = "0")
    String dictVal;//字典值

    @ApiModelProperty(value = "字典值描述",example = "女")
    String dictValInfo;//字典值描述

}
