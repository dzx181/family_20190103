package com.senb.familyedu.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.senb.familyedu.entity.EduUser;
import com.senb.familyedu.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
@Controller
public class EduUserController {
    @Autowired
    private EduUserService eduUserService;

    @RequestMapping("/toLogin")
    public String toLogin(EduUser user, HttpServletRequest request) {
        //查询所有的老师
        EntityWrapper<EduUser> entityWrapper = new EntityWrapper<>();
        //登录逻辑
        entityWrapper.setEntity(user);
        EduUser eduUser = eduUserService.selectOne(entityWrapper);
        if (eduUser!=null){
            request.getSession().setAttribute("user",eduUser);
        }
        return "redirect:/index";
    }

    @RequestMapping("/toRegister")
    public String toRegister(EduUser user, HttpServletRequest request) {

        boolean flag = eduUserService.insert(user);
       if (flag){request.setAttribute("msg","注册成功，请登录");}
        return "login";
    }

    @RequestMapping("/toUpdateView")
    public String toUpdateView(HttpServletRequest request) {
        HttpSession session = request.getSession();
        EduUser eduUser = (EduUser) session.getAttribute("user");
        request.setAttribute("eduUserEdit",eduUser);
        //修改成功后的msg
        String msg = (String) request.getAttribute("msg");
        if (msg!=null){
            request.setAttribute("msg",msg);
            EntityWrapper<EduUser> entityWrapper = new EntityWrapper<>();
            entityWrapper.setEntity(new EduUser().setId(eduUser.getId()));
            EduUser newUser = eduUserService.selectOne(entityWrapper);
            session.setAttribute("user",newUser);
            request.setAttribute("eduUserEdit",newUser);
        }

        return "userInfo";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(EduUser user, HttpServletRequest request) {
        boolean flag = eduUserService.updateById(user);
        if (flag){request.setAttribute("msg","修改成功");}
        return "forward:/toUpdateView";
    }
    @RequestMapping("/logOff")
    public String logOff(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }
}

