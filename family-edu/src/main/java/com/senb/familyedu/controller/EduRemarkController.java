package com.senb.familyedu.controller;


import com.senb.familyedu.entity.EduRemark;
import com.senb.familyedu.entity.EduUser;
import com.senb.familyedu.entity.vo.EduCourseVO;
import com.senb.familyedu.service.EduCourseService;
import com.senb.familyedu.service.EduRemarkService;
import com.senb.familyedu.service.EduUserService;
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
public class EduRemarkController {
    @Autowired
    private EduRemarkService eduRemarkService;
    @Autowired
    private EduCourseService eduCourseService;

    @RequestMapping("/insertRemark")
    public String insertRemark(EduRemark remark, HttpServletRequest request, Integer courseId) {

        if (remark != null) {
            HttpSession session = request.getSession();
            EduUser eduUser = (EduUser) session.getAttribute("user");
            remark.setUserStuId(eduUser.getId());
            boolean flag = eduRemarkService.insert(remark);
            if (flag) {
                request.setAttribute("msg", "评论成功");
            }
        }
        //查找具体的视频课程
        EduCourseVO eduCourse = eduCourseService.showCourseById(courseId);
        List<EduRemark> eduRemarkList = eduRemarkService.showRemarkByTeachId(eduCourse.getUserTea().getId());
        request.setAttribute("eduCourseById", eduCourse);
        request.setAttribute("eduRemarkList", eduRemarkList);
        return "playViedo";
    }

    @RequestMapping("/delteteRemark")
    public String delteteRemark(Integer remarkId, Integer courseId, HttpServletRequest request) {
        eduRemarkService.deleteById(remarkId);
        //查找具体的视频课程
        EduCourseVO eduCourse = eduCourseService.showCourseById(courseId);
        List<EduRemark> eduRemarkList = eduRemarkService.showRemarkByTeachId(eduCourse.getUserTea().getId());
        request.setAttribute("eduCourseById", eduCourse);
        request.setAttribute("eduRemarkList", eduRemarkList);
        return "playViedo";
    }
}

