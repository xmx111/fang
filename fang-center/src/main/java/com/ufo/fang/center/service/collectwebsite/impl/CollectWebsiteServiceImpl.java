package com.ufo.fang.center.service.collectWebsite.impl;

import com.ufo.fang.center.dao.collectWebsite.CollectWebsiteDAO;
import com.ufo.fang.center.model.CollectWebsite;
import com.ufo.fang.center.service.collectWebsite.CollectWebsiteService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * CollectWebsite服务实现
 *
 * @author generator
 * @created 2016-07-18
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
