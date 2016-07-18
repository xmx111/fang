package com.ufo.fang.center.service.agent.impl;

import com.ufo.fang.center.dao.agent.AgentDAO;
import com.ufo.fang.center.model.Agent;
import com.ufo.fang.center.service.agent.AgentService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Agent服务实现
 *
 * @author generator
 * @created 2016-07-18
 */
@Service
public class AgentServiceImpl extends BaseServiceImpl<Agent, Long> implements AgentService {

    @Autowired
    AgentDAO agentDAO;

    @Override
    protected BaseDAO<Agent, Long> getDAO() {
        return agentDAO;
    }
}
