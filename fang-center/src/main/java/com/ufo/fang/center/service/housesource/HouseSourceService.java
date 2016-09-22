package com.ufo.fang.center.service.housesource;

import com.ufo.fang.center.model.HouseSource;
import com.ufo.fang.center.model.HouseSourceSO;
import com.ufo.fang.common.exceptions.ServiceException;
import com.ufo.fang.common.service.BaseService;

/***
 * HouseSource服务
 *
 * @author generator
 * @created 2016-07-19
 */
public interface HouseSourceService extends BaseService<HouseSource, Long> {

    void add(HouseSourceSO so) throws ServiceException;

}
