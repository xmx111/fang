package com.ufo.fang.center.service.grading.impl;

import com.ufo.fang.center.dao.grading.GradingDAO;
import com.ufo.fang.center.model.Grading;
import com.ufo.fang.center.service.grading.GradingService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Grading服务实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Service
public class GradingServiceImpl extends BaseServiceImpl<Grading, Long> implements GradingService {

    @Autowired
    GradingDAO gradingDAO;

    @Override
    protected BaseDAO<Grading, Long> getDAO() {
        return gradingDAO;
    }
}
