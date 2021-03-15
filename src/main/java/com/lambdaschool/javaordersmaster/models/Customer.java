package com.lambdaschool.javaordersmaster.models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String custcity;

    private String workingarea;

    private String custcountry;

    private String grade;

    private double openingamt;

    private double receiveamt;

    private double paymentamt;

    private double outstandingamt;

    private String phone;

//  Long foreign key (one agent to many customers) not null
    @OneToMany(mappedBy = "agents")
    private long agentcode;
}
