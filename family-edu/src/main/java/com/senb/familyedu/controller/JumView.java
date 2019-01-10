package com.senb.familyedu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.senb.familyedu.entity.EduUser;
import com.senb.familyedu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private EduUserService eduUserService;
    /**
     * 跳转主页
     * @return
     */
    @RequestMapping("/")
    public String view(HttpServletRequest request){
        //查询所有的老师
        EntityWrapper<EduUser> entityWrapper = new EntityWrapper<>();
        List<EduUser> teachList = eduUserService.selectList(entityWrapper.eq("status",2));
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("teachList",teachList);
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
