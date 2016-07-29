package com.ufo.fang.center.service.agentthirdaccount.impl;

import com.ufo.fang.center.dao.agentthirdaccount.AgentThirdAccountDAO;
import com.ufo.fang.center.model.AgentThirdAccount;
import com.ufo.fang.center.service.agentthirdaccount.AgentThirdAccountService;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * AgentThirdAccount服务实现
 *
 * @author generator
 * @created 2016-07-19
 */
@Service
public class AgentThirdAccountServiceImpl extends BaseServiceImpl<AgentThirdAccount, Long> implements AgentThirdAccountService {

    @Autowired
    AgentThirdAccountDAO agentThirdAccountDAO;

    @Override
    protected BaseDAO<AgentThirdAccount, Long> getDAO() {
        return agentThirdAccountDAO;
    }
}
