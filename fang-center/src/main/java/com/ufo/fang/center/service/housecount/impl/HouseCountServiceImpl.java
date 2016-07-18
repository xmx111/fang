package com.ufo.fang.center.service.houseCount.impl;

import com.ufo.fang.center.dao.houseCount.HouseCountDAO;
import com.ufo.fang.center.model.HouseCount;
import com.ufo.fang.center.service.houseCount.HouseCountService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * HouseCount服务实现
 *
 * @author generator
 * @created 2016-07-18
 */
@Service
public class HouseCountServiceImpl extends BaseServiceImpl<HouseCount, Long> implements HouseCountService {

    @Autowired
    HouseCountDAO houseCountDAO;

    @Override
    protected BaseDAO<HouseCount, Long> getDAO() {
        return houseCountDAO;
    }
}
