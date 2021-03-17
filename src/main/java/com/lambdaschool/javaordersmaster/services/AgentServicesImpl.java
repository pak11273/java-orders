package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Agent;
import com.lambdaschool.javaordersmaster.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "agentService")
public class AgentServicesImpl implements AgentServices {
    @Autowired
    private AgentsRepository agentrepos;

    @Transactional
    @Override
    public Agent save(Agent agent)
    {
        return agentrepos.save(agent);
    }

    @Override
    public Agent findById(long agentid) {
        return agentrepos.findById(agentid).orElseThrow(()-> new EntityNotFoundException("Agent " + agentid + " was not found."));
    }

}
