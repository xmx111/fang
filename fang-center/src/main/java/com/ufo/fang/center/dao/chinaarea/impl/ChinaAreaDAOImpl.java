package com.ufo.fang.center.dao.chinaArea.impl;

import com.ufo.fang.center.dao.chinaArea.ChinaAreaDAO;
import com.ufo.fang.center.dao.chinaArea.mapper.ChinaAreaMapper;
import com.ufo.fang.center.model.ChinaArea;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * ChinaArea数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-18
 */
@Repository
public class ChinaAreaDAOImpl extends BaseDAOImpl<ChinaArea, Long> implements ChinaAreaDAO {

    @Autowired
    ChinaAreaMapper chinaAreaMapper;

    @Override
    protected BaseMapper<ChinaArea, Long> getMapper() {
        return chinaAreaMapper;
    }

}
