package com.sdtech.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Date 2020/5/26 11:42
 * @Created by Hrz
 */
@RestController
public class IndexCtl   {

    @GetMapping("/demo")
    public String demo(HttpServletRequest request){
        System.out.println(request.getParameterMap());
        return "this is spring boot";
    }
}
