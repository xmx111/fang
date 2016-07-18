package com.ufo.fang.center.service.gradingInfo.impl;

import com.ufo.fang.center.dao.gradingInfo.GradingInfoDAO;
import com.ufo.fang.center.model.GradingInfo;
import com.ufo.fang.center.service.gradingInfo.GradingInfoService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * GradingInfo服务实现
 *
 * @author generator
 * @created 2016-07-18
 */
@Service
public class GradingInfoServiceImpl extends BaseServiceImpl<GradingInfo, Long> implements GradingInfoService {

    @Autowired
    GradingInfoDAO gradingInfoDAO;

    @Override
    protected BaseDAO<GradingInfo, Long> getDAO() {
        return gradingInfoDAO;
    }
}
