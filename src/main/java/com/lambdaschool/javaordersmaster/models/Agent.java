package com.lambdaschool.javaordersmaster.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long agentcode;

    private String agentname;

    private String workingarea;

    private double commission;

    private String phone;

   @OneToMany(mappedBy = "agent",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "ownerpayments",
    joinColumns = @JoinColumn(name = "ownerid"),
    inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payment> payments = new HashSet<>();   private String country;

    public Agent() {
    }

    public Agent(String agentname, String workingarea, double commission, String phone, List<Customer> customers, Set<Payment> payments, String country) {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.customers = customers;
        this.payments = payments;
        this.country = country;
    }
}
