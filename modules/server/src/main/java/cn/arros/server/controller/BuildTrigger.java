package cn.arros.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Verge
 * @Date 2021/10/31 10:11
 * @Version 1.0
 */
@RestController
@RequestMapping("/server/trigger")
public class BuildTrigger {
    @PostMapping()
    public void test(@RequestBody String s){
        System.out.println(s);
    }
}
