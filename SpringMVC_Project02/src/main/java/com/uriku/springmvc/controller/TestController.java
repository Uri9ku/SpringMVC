package com.uriku.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Uriku
 * @Date: 2022/04/05/17:05
 * @Description:
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";  //返回的是 html 文件，即访问地址
    }

    @RequestMapping("/param")
    public String test_param(){
        return "test_param";
    }

}
