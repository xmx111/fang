package com.ufo.fang.center.dao.grading.impl;

import com.ufo.fang.center.dao.grading.GradingDAO;
import com.ufo.fang.center.dao.grading.mapper.GradingMapper;
import com.ufo.fang.center.model.Grading;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * Grading数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class GradingDAOImpl extends BaseDAOImpl<Grading, Long> implements GradingDAO {

    @Autowired
    GradingMapper gradingMapper;

    @Override
    protected BaseMapper<Grading, Long> getMapper() {
        return gradingMapper;
    }

}
