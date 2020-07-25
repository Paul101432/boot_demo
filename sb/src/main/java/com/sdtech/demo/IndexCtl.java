package com.sdtech.demo;


import com.jfinal.plugin.activerecord.Db;
import com.sdtech.demo.model.BaseDict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description TODO
 * @Date 2020/5/26 11:42
 * @Created by Hrz
 */
@Api(value = "字典管理", tags = "系统字典管理接口")
@RestController
public class IndexCtl   {

    @GetMapping("/demo")
    public String demo(HttpServletRequest request){
        System.out.println(request.getParameterMap());
        return "this is spring boot";
    }


    @GetMapping(value = "/list")
    @ApiOperation(value = "获取系统字典列表")
    //@ApiResponses(@ApiResponse(code = 200, message = "处理成功",response = DictRespDto.class))
    public SDPage<DictRespDto> list(QueryDicDto queryDicDto){

        BaseDict.dao.paginate(1,100,Db.getSqlPara("dictPage",queryDicDto));

        List<DictRespDto> dd=  Db.template( "dictPage",queryDicDto).query();
        return SDPage.page();
    }
}
