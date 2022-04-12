package com.uriku.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Uriku
 * @Date: 2022/04/05/15:10
 * @Description: 控制器类
 */

// 创建 bean 对象，控制器
@Controller
// 下面图标意思为当前类的对象交给 IOC 容器管理
public class HelloController {

    // "/" -->WEB-INF/templates/index.html
    @RequestMapping("/")
    // 请求映射
    public String index(){
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarGet(){
        return "target";
    }

}
