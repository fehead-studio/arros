package cn.arros.server.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author Verge
 * @Date 2021/12/25 23:44
 * @Version 1.0
 */
@RestController
@RequestMapping
public class TestController {
    @GetMapping("/ping/{message}")
    public String ping(@PathVariable String message) {
        return message;
    }
}
