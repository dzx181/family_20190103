package com.senb.familyedu.service;

import com.senb.familyedu.entity.EduCourse;
import com.baomidou.mybatisplus.service.IService;
import com.senb.familyedu.entity.vo.EduCourseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
public interface EduCourseService extends IService<EduCourse> {
    EduCourseVO showCourseById(Integer courseId);
}
