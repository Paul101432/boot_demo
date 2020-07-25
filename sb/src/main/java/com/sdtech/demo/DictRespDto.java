package com.sdtech.demo;

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
    String dictId;

    @ApiModelProperty(value = "上级编码",example = "100")
    String parentsId;

    @ApiModelProperty(value = "字典键",example = "gender")
    String dictKey;

    @ApiModelProperty(value = "字典键描述",example = "性别")
    String dictKeyInfo;

    @ApiModelProperty(value = "字典值",example = "0")
    String dictVal;

    @ApiModelProperty(value = "字典值描述",example = "女")
    String dictValInfo;


}
