package com.safe.web1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestDemoController {
    @RequestMapping("/say")
    @ResponseBody
    String testSay(){
        return "testsay";
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String test() {
        System.out.println("请求测试");
        return "测试请求";
    }
}
