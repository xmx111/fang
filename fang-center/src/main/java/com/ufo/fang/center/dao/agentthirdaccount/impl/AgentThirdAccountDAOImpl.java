package com.ufo.fang.center.dao.agentthirdaccount.impl;

import com.ufo.fang.center.dao.agentthirdaccount.AgentThirdAccountDAO;
import com.ufo.fang.center.dao.agentthirdaccount.mapper.AgentThirdAccountMapper;
import com.ufo.fang.center.model.AgentThirdAccount;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * AgentThirdAccount数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class AgentThirdAccountDAOImpl extends BaseDAOImpl<AgentThirdAccount, Long> implements AgentThirdAccountDAO {

    @Autowired
    AgentThirdAccountMapper agentThirdAccountMapper;

    @Override
    protected BaseMapper<AgentThirdAccount, Long> getMapper() {
        return agentThirdAccountMapper;
    }

}
