package com.sdtech.demo.swagger;

import com.jfinal.plugin.activerecord.Db;
import com.sdtech.demo.SDPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// /doc.html
@Api(value = "字典管理", tags = "系统字典管理接口")
@RestController("/swagger")
public class SwaggerCtl {

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取系统字典列表")
    public SDPage<DictRespDto> list(QueryDicDto queryDicDto){
        List<DictRespDto> dd=  Db.template( "dictPage",queryDicDto).query();
        Db.paginate(1,10, Db.getSqlPara(""));
        return null;
    }

}
