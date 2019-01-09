package com.senb.familyedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
@Controller
public class JumView {
    /**
     * 跳转主页
     * @return
     */
    @RequestMapping("/")
    public String view(){
        return "index";
    }

    /**
     * 跳转各个页面
     * @return
     */
    @RequestMapping("/{viewName}")
    public String view(@PathVariable("viewName") String viewName){
        return viewName;
    }

}
