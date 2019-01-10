package com.senb.familyedu.service;

import com.senb.familyedu.entity.EduRemark;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
public interface EduRemarkService extends IService<EduRemark> {
    List<EduRemark> showRemarkByTeachId(Integer teacheId);
}
