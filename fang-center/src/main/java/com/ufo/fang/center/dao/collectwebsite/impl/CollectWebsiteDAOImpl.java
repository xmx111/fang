package com.ufo.fang.center.dao.collectwebsite.impl;

import com.ufo.fang.center.dao.collectwebsite.CollectWebsiteDAO;
import com.ufo.fang.center.dao.collectwebsite.mapper.CollectWebsiteMapper;
import com.ufo.fang.center.model.CollectWebsite;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * CollectWebsite数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class CollectWebsiteDAOImpl extends BaseDAOImpl<CollectWebsite, Long> implements CollectWebsiteDAO {

    @Autowired
    CollectWebsiteMapper collectWebsiteMapper;

    @Override
    protected BaseMapper<CollectWebsite, Long> getMapper() {
        return collectWebsiteMapper;
    }

}
