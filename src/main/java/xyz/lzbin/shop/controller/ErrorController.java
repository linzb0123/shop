package xyz.lzbin.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lzbin.shop.service.HelloService;

/**
 * @author lzb
 * 2019/12/2
 */
@Controller
public class ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @Autowired
    private HelloService helloService;


    @RequestMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("hello","hello World");
//        helloService.hello();
        return "hello";
    }
    @RequestMapping("/error/404")
    public String error404() {
        return "/error/404";
    }
    @RequestMapping("/error/500")
    public String error500() {
        return "/error/500";
    }




    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
