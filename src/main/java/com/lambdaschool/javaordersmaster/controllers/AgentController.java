package com.lambdaschool.javaordersmaster.controllers;

import com.lambdaschool.javaordersmaster.models.Agent;
import com.lambdaschool.javaordersmaster.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentServices agentServices;

    // http://localhost:2019/agents/agent/9
    @GetMapping(value = "/agent/{agentid}", produces = "application/json")
    public ResponseEntity<?> findById(@PathVariable long agentid)
    {
        Agent a = agentServices.findById(agentid);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

}
