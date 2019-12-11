package cn.bfay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TestController.
 *
 * @author wangjiannan
 * @since 2019/12/11
 */
@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "I am test；我是测试";
    }

}
