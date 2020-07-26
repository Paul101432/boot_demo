package com.sdtech.demo.smart_doc;


import com.jfinal.plugin.activerecord.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Description TODO
 * @Date 2020/5/26 11:42
 * @Created by Hrz
 */
@RestController
public class IndexCtl {


    /**
     * 字典分页
     * @param queryDicDto
     */
    @GetMapping("list")
    public Page<DictRespDto> list(QueryDicDto queryDicDto){

        // BaseDict.dao.paginate(1,10, Db.getSqlPara("dictPage",queryDicDto));
        return null;
        //Db.template("dictPage",queryDicDto).paginate(1,10);
    }

    /**
     * 多文件提交
     * @param vo
     * @param fs
     * @return
     */
    @PostMapping(value = "/file")
    public String getFile(ContractCallbackVo vo,
                          @RequestParam Map<String, MultipartFile> fs) {

        System.out.println(vo.getFileId());
        System.out.println(vo.getProjectCode());
        System.out.println(vo.getSignList());
        System.out.println(vo.getSmsList());
        System.out.println(vo.getIsDone());

        System.out.println(fs.size());
        System.out.println(fs);
        return "ok";
    }

}
