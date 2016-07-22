package com.ufo.fang.center.dao.houserelease.impl;

import com.ufo.fang.center.dao.houserelease.HouseReleaseDAO;
import com.ufo.fang.center.dao.houserelease.mapper.HouseReleaseMapper;
import com.ufo.fang.center.model.HouseRelease;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * HouseRelease数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class HouseReleaseDAOImpl extends BaseDAOImpl<HouseRelease, Long> implements HouseReleaseDAO {

    @Autowired
    HouseReleaseMapper houseReleaseMapper;

    @Override
    protected BaseMapper<HouseRelease, Long> getMapper() {
        return houseReleaseMapper;
    }

}
