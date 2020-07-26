package com.sdtech.demo.smart_doc;

import lombok.Data;

@Data
public class ContractCallbackVo {

    /**
     * 文件编码
     */
    private String fileId;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 是否结束
     */
    private int isDone;

    /**
     * 签署列表
     */
    private String signList;

    /**
     * 短信列表
     */
    private String smsList;


}
