package com.example.spring.dao;

/**
 * Created by tomidaat on 2017/06/26.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.spring.controller.CustomerRestController;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.spring.model.Customer;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAO {
    final Logger logger = Logger.getLogger(String.valueOf(CustomerDAO.class));
    // Dummy database. Initialize with some dummy values.
    private static List customers;
    {
        customers = new ArrayList();
        customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
        customers.add(new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
        customers.add(new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
    }

    /**
     * Returns list of customers from dummy database.
     *
     * @return list of customers
     */
    public List list() {
        return customers;
    }

    /**
     * Return customer object for given id from dummy database. If customer is
     * not found for id, returns null.
     *
     * @param id
     *            customer id
     * @return customer object for given id
     */
    public Customer get(Long id) throws InterruptedException {
        logger.info("dao get start");
        for (Object c1 : customers) {
            Customer c = (Customer)c1;
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Create new customer in dummy database. Updates the id and insert new
     * customer in list.
     *
     * @param customer
     *            Customer object
     * @return customer object with updated id
     */

    public Customer create(Customer customer) throws InterruptedException {
        logger.info("create start");
        Thread.sleep(1000);
        customer.setId(System.currentTimeMillis());
        customers.add(customer);
        logger.info("create end");
        return customer;
    }

    /**
     * Delete the customer object from dummy database. If customer not found for
     * given id, returns null.
     *
     * @param id
     *            the customer id
     * @return id of deleted customer object
     */
    public Long delete(Long id) {

        for (Object c1 : customers) {
            Customer c = (Customer)c1;
            if (c.getId().equals(id)) {
                customers.remove(c);
                return id;
            }
        }

        return null;
    }

    /**
     * Update the customer object for given id in dummy database. If customer
     * not exists, returns null
     *
     * @param id
     * @param customer
     * @return customer object with id
     */
    public Customer update(Long id, Customer customer) {

        for (Object c1 : customers) {
            Customer c = (Customer)c1;
            if (c.getId().equals(id)) {
                customer.setId(c.getId());
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }

        return null;
    }

}
