package com.senb.familyedu.service.impl;

import com.senb.familyedu.entity.EduRemark;
import com.senb.familyedu.dao.EduRemarkDao;
import com.senb.familyedu.service.EduRemarkService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
@Service
public class EduRemarkServiceImpl extends ServiceImpl<EduRemarkDao, EduRemark> implements EduRemarkService {
    @Autowired
    private EduRemarkDao eduRemarkDao;

    @Override
    public List<EduRemark> showRemarkByTeachId(Integer teacheId) {
        return eduRemarkDao.showRemarkByTeachId(teacheId);
    }
}
