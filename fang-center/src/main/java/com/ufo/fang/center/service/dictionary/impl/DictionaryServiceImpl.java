package com.ufo.fang.center.service.dictionary.impl;

import com.ufo.fang.center.dao.dictionary.DictionaryDAO;
import com.ufo.fang.center.model.Dictionary;
import com.ufo.fang.center.service.dictionary.DictionaryService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Dictionary服务实现
 *
 * @author generator
 * @created 2016-07-18
 */
@Service
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary, Long> implements DictionaryService {

    @Autowired
    DictionaryDAO dictionaryDAO;

    @Override
    protected BaseDAO<Dictionary, Long> getDAO() {
        return dictionaryDAO;
    }
}
