package com.sdtech.demo;

import com.jfinal.config.*;
import com.jfinal.kit.LogKit;
import com.jfinal.server.undertow.UndertowConfig;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

/**
 * @Date 2020/5/26 11:24
 * @Created by Hrz
 */
public class JFConfig extends JFinalConfig {

    public static void main(String[] args) {
        UndertowConfig thatConfig = new UndertowConfig(JFConfig.class);
        UndertowServer.create(thatConfig).start();
        LogKit.error(" demo  ");
    }


    @Override
    public void configConstant(Constants me) {

    }

    @Override
    public void configRoute(Routes me) {
        me.add("/",IndexCtl.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
