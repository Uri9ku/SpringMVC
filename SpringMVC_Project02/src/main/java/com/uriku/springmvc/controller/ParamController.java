package com.uriku.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Uriku
 * @Date: 2022/04/12/20:36
 * @Description:
 * 控制器方法，用于处理请求。
 * 浏览器发送的请求都会由前端控制器处理，
 * 之后执行了对应的控制器方法，将请求和 RequestMapping 进行匹配
 * 来找到控制器方法的过程，这个过程是由 DispatcherServlet 完成的
 * DispatcherServlet 然后间接调用控制器方法。
 *
 * 这里的处理过程是请求地址和 RequestMapping 注解
 * DispatcherServlet 封装了很多数据，调用了控制器方法，
 * 就会根据当前的控制器方法参数来为当前方法注入参数，即为参数赋值
 */

@Controller
public class ParamController {

    @RequestMapping("/testparam")
    // HttpServletRequest 是请求对象，可以直接使用 request，但是需要我们赋值
     /*但是这个方法是 DispatcherServlet 底层调用的，
     根据控制器方法的形参来为这个方法注入不一样的值
     HttpServletRequest 对象可以将当前 DispatcherServlet
     里面所获得的当前的 request 对象赋值给参数*/
    // 形参 request 表示当前的请求
    // 原生的
    public String testServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + " password:" + password);
        return "success";
    }

    @RequestMapping("/testparammvc")
    public String testParamMVC(String username,String password){
        // 这个参数名和请求参数名一样就行
        System.out.println("username:" + username + " password:" + password);
        return "success";
    }

    // 多个同名形参
    /*http://localhost:8080/SpringMVC_Project02_war_exploded/testparammvc?username=Uriku&password=&hobby=a&hobby=b&hobby=c*/

    @RequestMapping("/testparammvc2")
    //String[] hobby -> 数组地址
    // 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数
    //
    //若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
    //
    //若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
    public String testParamMVC2(String username,String password,String hobby){
        // 这个参数名和请求参数名一样就行
        System.out.println("username:" + username + " password:" + password + "hobby:" + hobby);
        return "success";
        /* username:aa password:aahobby:a,b,c */
    }
}
