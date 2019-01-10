package com.senb.familyedu.dao;

import com.senb.familyedu.entity.EduCourse;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.senb.familyedu.entity.vo.EduCourseVO;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
public interface EduCourseDao extends BaseMapper<EduCourse> {
    EduCourseVO showCourseById(Integer courseId);
}
