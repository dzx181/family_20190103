package com.senb.familyedu.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.senb.familyedu.entity.EduCourse;
import com.senb.familyedu.entity.EduSelect;
import com.senb.familyedu.entity.EduUser;
import com.senb.familyedu.entity.vo.EduSelectVO;
import com.senb.familyedu.service.EduCourseService;
import com.senb.familyedu.service.EduSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class EduSelectController {
    @Autowired
    private EduSelectService eduSelectService;


    @RequestMapping("/selectCourse")
    public String selectCourse(Integer courseId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        EduUser eduUser = (EduUser) session.getAttribute("user");

        //查找具体的视频课程
        boolean flag = eduSelectService.insert(new EduSelect().setCourseId(courseId).setUserId(eduUser.getId()));
        if (flag) {
            request.setAttribute("msg", "选课成功");
        }else {
            request.setAttribute("msg", "选课失败");
        }
        return "forward:/selectEduCourse";
    }

    @RequestMapping("/selectCourseByUserId")
    public String selectCourseByUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        EduUser eduUser = (EduUser) session.getAttribute("user");

        //查找具体的视频课程

        List<EduSelectVO> eduSelectList = eduSelectService.selectCourseByUserId(eduUser.getId());
        if (!eduSelectList.isEmpty()){
            for (int i = 0; i < eduSelectList.size(); i++) {
                //组装时间段
                String timeStr = eduSelectList.get(i).getCourse().getTimeSection();
                if (timeStr.equals("9:00 - 10:20")){
                    eduSelectList.get(i).getCourse().setTimeSection("1");
                }else if (timeStr.equals("10:20 - 12:00")){
                    eduSelectList.get(i).getCourse().setTimeSection("2");
                }else if(timeStr.equals("14:00 - 15:20")){
                    eduSelectList.get(i).getCourse().setTimeSection("3");
                }else if(timeStr.equals("15:30 - 16:50")){
                eduSelectList.get(i).getCourse().setTimeSection("4");
                }else if(timeStr.equals("17:00 - 18:20")){
                    eduSelectList.get(i).getCourse().setTimeSection("5");
                }
                //组装星期
                String weekStr = eduSelectList.get(i).getCourse().getWeek();
                if (weekStr.equals("星期一")){
                    eduSelectList.get(i).getCourse().setWeek("1");
                }else if (weekStr.equals("星期二")){
                    eduSelectList.get(i).getCourse().setWeek("2");
                }else if(weekStr.equals("星期三")){
                    eduSelectList.get(i).getCourse().setWeek("3");
                }else if(weekStr.equals("星期四")){
                    eduSelectList.get(i).getCourse().setWeek("4");
                }else if(weekStr.equals("星期五")){
                    eduSelectList.get(i).getCourse().setWeek("5");
                }
            }
        }
        request.setAttribute("eduSelectList", eduSelectList);
        return "buytoday";
    }

    @RequestMapping("/deleteSelect")
    public String deleteSelect(Integer selectId) {
      eduSelectService.deleteById(selectId);
        return "redirect:/selectCourseByUserId";
    }

}

