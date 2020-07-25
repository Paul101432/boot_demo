package com.sdtech.demo;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Description
 * @Date 2020/3/2 11:51
 * @Created by Hrz
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {



    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sdtech.demo"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo( ) {
        return new ApiInfoBuilder()
                .title("title")
                .contact(new Contact("name","url","email"))
                .description("desc")
                .version("version")
                .build();
    }

  private ArrayList<ResponseMessage> initErrRespMsgs(){
        ArrayList<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {{
            for (ResultCode resultCode :ResultCode.values()) {
                add(new ResponseMessageBuilder().code(resultCode.getCode()).message(resultCode.getMsg()).build());
            }
        }};
        return responseMessages;

    }
}
