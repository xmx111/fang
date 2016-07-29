package com.ufo.fang.center.dao.gradinginfo.impl;

import com.ufo.fang.center.dao.gradinginfo.GradingInfoDAO;
import com.ufo.fang.center.dao.gradinginfo.mapper.GradingInfoMapper;
import com.ufo.fang.center.model.GradingInfo;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * GradingInfo数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class GradingInfoDAOImpl extends BaseDAOImpl<GradingInfo, Long> implements GradingInfoDAO {

    @Autowired
    GradingInfoMapper gradingInfoMapper;

    @Override
    protected BaseMapper<GradingInfo, Long> getMapper() {
        return gradingInfoMapper;
    }

}
