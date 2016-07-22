package com.ufo.fang.center.service.house.impl;

import com.ufo.fang.center.dao.house.HouseDAO;
import com.ufo.fang.center.model.House;
import com.ufo.fang.center.service.house.HouseService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * House服务实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Service
public class HouseServiceImpl extends BaseServiceImpl<House, Long> implements HouseService {

    @Autowired
    HouseDAO houseDAO;

    @Override
    protected BaseDAO<House, Long> getDAO() {
        return houseDAO;
    }
}
