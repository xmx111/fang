package com.ufo.fang.center.service.housesource.impl;

import com.ufo.fang.center.dao.housesource.HouseSourceDAO;
import com.ufo.fang.center.model.HouseSource;
import com.ufo.fang.center.service.housesource.HouseSourceService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.exceptions.ServiceException;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/***
 * HouseSource服务实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Service
public class HouseSourceServiceImpl extends BaseServiceImpl<HouseSource, Long> implements HouseSourceService {

    @Autowired
    HouseSourceDAO houseSourceDAO;

    @Override
    protected BaseDAO<HouseSource, Long> getDAO() {
        return houseSourceDAO;
    }

    @Override
    public int add(HouseSource modal) throws ServiceException {
        try {
            Map param = new HashMap();
            param.put("url", modal.getUrl());
            if (CollectionUtils.isEmpty(houseSourceDAO.selectByParameters(param))) {
                return houseSourceDAO.insert(modal);
            } else {
                return 0;
            }
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
