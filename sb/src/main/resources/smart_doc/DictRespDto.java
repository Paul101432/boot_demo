package com.sdtech.demo.smart_doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "字典分页列表")
public class DictRespDto  extends BaseRespDto{

    @ApiModelProperty(value = "字典编码",example = "110")
    String dictId;//字典编码

    @ApiModelProperty(value = "上级编码",example = "100")
    String parentsId;//上级编码

    @ApiModelProperty(value = "字典键",example = "gender")
    String dictKey;//字典键

    @ApiModelProperty(value = "字典键描述",example = "性别")
    String dictKeyInfo;//字典键描述

    @ApiModelProperty(value = "字典值",example = "0")
    String dictVal;//字典值

    @ApiModelProperty(value = "字典值描述",example = "女")
    String dictValInfo;//字典值描述


}
