package com.ufo.fang.center.service.collectwebsite.impl;

import com.ufo.fang.center.dao.collectwebsite.CollectWebsiteDAO;
import com.ufo.fang.center.model.CollectWebsite;
import com.ufo.fang.center.service.collectwebsite.CollectWebsiteService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * CollectWebsite服务实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Service
public class CollectWebsiteServiceImpl extends BaseServiceImpl<CollectWebsite, Long> implements CollectWebsiteService {

    @Autowired
    CollectWebsiteDAO collectWebsiteDAO;

    @Override
    protected BaseDAO<CollectWebsite, Long> getDAO() {
        return collectWebsiteDAO;
    }
}
