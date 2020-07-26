package com.sdtech.demo.apidoc;

import com.jfinal.plugin.activerecord.Page;
import com.sdtech.demo.swagger.DictRespDto;
import com.sdtech.demo.swagger.QueryDicDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口文档
 */
@RequestMapping("/api/")
@RestController
public class ApiCtl {


    /**
     * 字典分页
     * @param queryDicDto
     */
    @PostMapping("list")
    public Page<DictRespDto> list(QueryDicDto queryDicDto){

        //Db.template("dictPage",queryDicDto).paginate(1,10)
        return null;
    }

}
