package com.lambdaschool.javaordersmaster.services;

import com.lambdaschool.javaordersmaster.models.Customer;
import com.lambdaschool.javaordersmaster.models.Order;
import com.lambdaschool.javaordersmaster.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomersRepository custrepos;

//    @Transactional
//    @Override
//    public Customer save(Customer customer)
    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        //POST -> new resource
        //PUT -> replace existing resource
        if (customer.getCustcode() != 0) {
            custrepos.findById(customer.getCustcode())
                    .orElseThrow(() -> new EntityNotFoundException("Customer " + customer.getCustcode() + " not found!"));
            newCustomer.setCustcode(customer.getCustcode());
        }

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        //OneToMany -> new resources that arent in the database yet
        newCustomer.getOrders().clear();
        for (Order m : customer.getOrders()) {
            Order newOrder = new Order();
            newOrder.setOrdamount(m.getOrdamount());
            newOrder.setOrderdescription(m.getOrderdescription());

            newOrder.setCustomer(newCustomer);

            newCustomer.getOrders().add(newOrder);
        }

        return custrepos.save(newCustomer);
    }

    @Override
    public List<Customer> findAllCustomers()
    {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long custid) {
        return custrepos.findById(custid).orElseThrow(()-> new EntityNotFoundException("Customer " + custid + " was not found."));
    }

    @Override
    public List<Customer> findByNameLike(String subname) {
        return custrepos.findByCustnameContainingIgnoringCase(subname);
    }

    @Override
    public void delete(long id) {
        custrepos.findById(id).orElseThrow(()-> new EntityNotFoundException("Restaurant " + id + " not found."));
        custrepos.deleteById(id);
    }
}
