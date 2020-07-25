package com.sdtech.demo;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.template.source.ClassPathSourceFactory;
import com.sdtech.demo.model._MappingKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Date 2020/3/6 16:08
 * @Created by Hrz
 */
@Configuration
public class ActiveRecordConfig {

    @Autowired
    private DataSource ds;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public ActiveRecordPlugin init() {
        ActiveRecordPlugin arp = new ActiveRecordPlugin(ds);
        arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));
        arp.setDialect(new MysqlDialect());
        arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
        arp.addSqlTemplate("/sd.sql");
         _MappingKit.mapping(arp);
        return arp;
    }
}
