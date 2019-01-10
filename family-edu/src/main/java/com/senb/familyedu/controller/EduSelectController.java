package com.senb.familyedu.controller;


import com.senb.familyedu.entity.EduCourse;
import com.senb.familyedu.entity.EduSelect;
import com.senb.familyedu.entity.EduUser;
import com.senb.familyedu.service.EduCourseService;
import com.senb.familyedu.service.EduSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
@RestController
@RequestMapping("/eduSelect")
public class EduSelectController {
    @Autowired
    private EduSelectService eduSelectService;

    @RequestMapping("/selectCourse")
    public String selectCourse(Integer courseId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        EduUser eduUser = (EduUser) session.getAttribute("user");

        //查找具体的视频课程
        boolean flag = eduSelectService.insert(new EduSelect().setCourseId(courseId).setUserId(eduUser.getId()));
       if (flag){request.setAttribute("msg","选课成功");}
        return "commodity";
    }

}

