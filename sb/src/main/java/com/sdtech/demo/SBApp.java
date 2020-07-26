package com.sdtech.demo;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import io.github.yedaxia.apidocs.plugin.markdown.MarkdownDocPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Date 2020/5/26 11:25
 * @Created by Hrz
 */
@SpringBootApplication
public class SBApp {

    public static void main(String[] args) {

        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\code_hrz\\boot_demo\\sb"); // 项目根目录
        config.setProjectName("ProjectName"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("D:\\code_hrz\\boot_demo\\sb"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        config.addPlugin(new MarkdownDocPlugin());
        Docs.buildHtmlDocs(config); // 执行生成文档


        SpringApplication.run(SBApp.class, args);
    }

}
