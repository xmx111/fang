package com.ufo.fang.center.service.chinaarea.impl;

import com.ufo.fang.center.dao.chinaarea.ChinaAreaDAO;
import com.ufo.fang.center.model.ChinaArea;
import com.ufo.fang.center.service.chinaarea.ChinaAreaService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * ChinaArea服务实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Service
public class ChinaAreaServiceImpl extends BaseServiceImpl<ChinaArea, Long> implements ChinaAreaService {

    @Autowired
    ChinaAreaDAO chinaAreaDAO;

    @Override
    protected BaseDAO<ChinaArea, Long> getDAO() {
        return chinaAreaDAO;
    }
}
