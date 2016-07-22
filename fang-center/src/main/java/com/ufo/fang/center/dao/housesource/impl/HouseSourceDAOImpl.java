package com.ufo.fang.center.dao.housesource.impl;

import com.ufo.fang.center.dao.housesource.HouseSourceDAO;
import com.ufo.fang.center.dao.housesource.mapper.HouseSourceMapper;
import com.ufo.fang.center.model.HouseSource;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * HouseSource数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class HouseSourceDAOImpl extends BaseDAOImpl<HouseSource, Long> implements HouseSourceDAO {

    @Autowired
    HouseSourceMapper houseSourceMapper;

    @Override
    protected BaseMapper<HouseSource, Long> getMapper() {
        return houseSourceMapper;
    }

}
