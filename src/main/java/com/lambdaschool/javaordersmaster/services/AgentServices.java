package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Agent;

import java.util.List;

public interface AgentServices {
    Agent save(Agent customer);

    Agent findById(long agentid);
}
