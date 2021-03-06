package com.ufo.fang.center.dao.housecount.impl;

import com.ufo.fang.center.dao.housecount.HouseCountDAO;
import com.ufo.fang.center.dao.housecount.mapper.HouseCountMapper;
import com.ufo.fang.center.model.HouseCount;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * HouseCount数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class HouseCountDAOImpl extends BaseDAOImpl<HouseCount, Long> implements HouseCountDAO {

    @Autowired
    HouseCountMapper houseCountMapper;

    @Override
    protected BaseMapper<HouseCount, Long> getMapper() {
        return houseCountMapper;
    }

}
