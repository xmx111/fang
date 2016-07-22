package com.ufo.fang.center.service.houserelease.impl;

import com.ufo.fang.center.dao.houserelease.HouseReleaseDAO;
import com.ufo.fang.center.model.HouseRelease;
import com.ufo.fang.center.service.houserelease.HouseReleaseService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * HouseRelease服务实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Service
public class HouseReleaseServiceImpl extends BaseServiceImpl<HouseRelease, Long> implements HouseReleaseService {

    @Autowired
    HouseReleaseDAO houseReleaseDAO;

    @Override
    protected BaseDAO<HouseRelease, Long> getDAO() {
        return houseReleaseDAO;
    }
}
