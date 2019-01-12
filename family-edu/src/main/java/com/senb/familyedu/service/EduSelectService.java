package com.senb.familyedu.service;

import com.senb.familyedu.entity.EduSelect;
import com.baomidou.mybatisplus.service.IService;
import com.senb.familyedu.entity.vo.EduSelectVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
public interface EduSelectService extends IService<EduSelect> {
    List<EduSelectVO> selectCourseByUserId(Integer userId);
}
