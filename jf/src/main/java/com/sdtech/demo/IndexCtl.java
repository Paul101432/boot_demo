package com.sdtech.demo;

import com.jfinal.core.Controller;
import com.jfinal.kit.LogKit;

/**
 * @Date 2020/5/26 11:42
 * @Created by Hrz
 */
public class IndexCtl extends Controller {

    public void demo(){
        System.out.println(getKv());
        renderJson("this is jfianl");
    }

    public void err(){
      try {
          System.out.println( 1/0);
      }catch (Exception e){
          e.printStackTrace();
          LogKit.error("error to log ",e);
      }finally {
          renderJson("this is err ");
      }
    }



}
