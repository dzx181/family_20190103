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

import javax.servlet.http.HttpServletRequest;
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
        EntityWrapper<EduUser> entityWrapper = new EntityWrapper<>();
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

    @RequestMapping("/toUpdate")
    public String toUpdate(EduUser user, HttpServletRequest request) {
        boolean flag = eduUserService.updateById(user);
        if (flag){request.setAttribute("msg","修改成功");}
        return "login";
    }
}

