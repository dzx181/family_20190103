package com.senb.familyedu.dao;

import com.senb.familyedu.entity.EduRemark;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
public interface EduRemarkDao extends BaseMapper<EduRemark> {
    List<EduRemark> showRemarkByTeachId(Integer teacheId);
}
