package com.uriku.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Uriku
 * @Date: 2022/04/05/20:47
 * @Description: 多个控制器的话，后面的控制器的类要在类添加 @RequestMapping
 */

/*@Controller
public class RequestMappingController {

    @RequestMapping("/")
    public String index(){
        return "target";
    }
    // 会报错，RequestMapping 只能映射一个，不然会报错
}*/

@Controller

//@RequestMapping标识一个类：设置映射请求的请求路径的初始信息，避免了多个控制器的名称冲突
@RequestMapping("test")
public class RequestMappingController{

    //@RequestMapping标识一个方法：设置映射请求请求路径的具体信息
    @RequestMapping("/testRequestMapping")
    public String success(){
      return "success";
    }

    // 数组，满足其中一个都可以跳转
    // value 属性必须满足，value 越多匹配更精确
    @RequestMapping(
            value = {"/array","arrays"}
    )
    public String array(){
        return "array";
    }

    @RequestMapping(
            value = "form",
            method = {
                    RequestMethod.GET,
                    RequestMethod.POST}
    )
    public String form(){
        return "form";
    }

    @PostMapping("formPost")
    public String formPost(){
        return "formPost";
    }

    @RequestMapping(
            value = "testPut",
            method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    // value ？：表示任意的单个字符
    @RequestMapping("/a?a/testAnt")
    public String testAnt(){
        return "success";
    }

    //*：表示任意的0个或多个字符
    @RequestMapping("/a*a/testAnt2")
    public String testAnt2(){
        return "success";
    }

    // **：表示任意的一层或多层目录
    // 注意：在使用**时，只能使用/**/xxx的方式
    // 只能写在 ** 里面
    @RequestMapping("/**/testAnt3")
    public String testAnt3(){
        return "success";
    }

    // 重  点，Restful 会用
    // 测试 RequestMapping 支持路径中的占位符
    // 将 RequestMapping 的 id 占位符所表示的值自动赋值给形参 id
    // 请求路径不写占位符或者写 / 的话会 404
    @RequestMapping("/testPath/{id}")
    public String testPath(@PathVariable("id")Integer id){
        System.out.println("id:" + id);
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username") String username){
        System.out.println("id:" + id);
        System.out.println("username:" + username);
        return "success";
    }

}
