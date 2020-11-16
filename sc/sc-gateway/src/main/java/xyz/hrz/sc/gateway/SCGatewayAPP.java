package xyz.hrz.sc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date 2020/6/23 16:34
 * @Created by Hrz
 */
@ComponentScan("xyz.hrz.sc.gateway")
@SpringCloudApplication
public class SCGatewayAPP {
    public static void main(String[] args) {
        SpringApplication.run(SCGatewayAPP.class, args);
    }
}
