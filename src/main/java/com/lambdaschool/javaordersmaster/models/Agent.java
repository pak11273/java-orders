package com.lambdaschool.javaordersmaster.models;

import javax.persistence.*;

@Entity
@Table(name="agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long agentid;

    private String agentname;

    private String workingarea;

    private double commission;

    private String phone;

    private String country;
}
