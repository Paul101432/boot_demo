package xyz.hrz.sc.gateway.ctl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/6/23 16:36
 * @Created by Hrz
 */
@Slf4j
@RestController
@RequestMapping("/")
public class IndexCtl {


    @GetMapping("/demo")
    public String redis() {
        return " this is sc'gateway ";
    }
}
