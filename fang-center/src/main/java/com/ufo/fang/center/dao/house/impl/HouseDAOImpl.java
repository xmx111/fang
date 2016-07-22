package com.ufo.fang.center.dao.house.impl;

import com.ufo.fang.center.dao.house.HouseDAO;
import com.ufo.fang.center.dao.house.mapper.HouseMapper;
import com.ufo.fang.center.model.House;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * House数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class HouseDAOImpl extends BaseDAOImpl<House, Long> implements HouseDAO {

    @Autowired
    HouseMapper houseMapper;

    @Override
    protected BaseMapper<House, Long> getMapper() {
        return houseMapper;
    }

}
