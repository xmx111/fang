package com.ufo.fang.center.dao.dictionary.impl;

import com.ufo.fang.center.dao.dictionary.DictionaryDAO;
import com.ufo.fang.center.dao.dictionary.mapper.DictionaryMapper;
import com.ufo.fang.center.model.Dictionary;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * Dictionary数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-18
 */
@Repository
public class DictionaryDAOImpl extends BaseDAOImpl<Dictionary, Long> implements DictionaryDAO {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    protected BaseMapper<Dictionary, Long> getMapper() {
        return dictionaryMapper;
    }

}
