package com.senb.familyedu.dao;

import com.senb.familyedu.entity.EduUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
public interface EduUserDao extends BaseMapper<EduUser> {
    EduUser selectEdueById(Integer userId);
}
