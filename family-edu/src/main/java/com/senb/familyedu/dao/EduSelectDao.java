package com.senb.familyedu.dao;

import com.senb.familyedu.entity.EduSelect;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.senb.familyedu.entity.EduUser;
import com.senb.familyedu.entity.vo.EduSelectVO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
public interface EduSelectDao extends BaseMapper<EduSelect> {
    List<EduSelectVO> selectCourseByUserId(Integer userId);
}
