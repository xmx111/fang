package com.ufo.fang.center.dao.agent.impl;

import com.ufo.fang.center.dao.agent.AgentDAO;
import com.ufo.fang.center.dao.agent.mapper.AgentMapper;
import com.ufo.fang.center.model.Agent;
import com.ufo.fang.common.dao.impl.BaseDAOImpl;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/***
 * Agent数据库操作DAO实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Repository
public class AgentDAOImpl extends BaseDAOImpl<Agent, Long> implements AgentDAO {

    @Autowired
    AgentMapper agentMapper;

    @Override
    protected BaseMapper<Agent, Long> getMapper() {
        return agentMapper;
    }

}
