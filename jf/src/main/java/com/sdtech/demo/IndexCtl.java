package com.sdtech.demo;

import com.jfinal.core.Controller;

/**
 * @Description TODO
 * @Date 2020/5/26 11:42
 * @Created by Hrz
 */
public class IndexCtl extends Controller {

    public void demo(){
        System.out.println(getKv());
        renderJson("this is jfianl");
    }
}
