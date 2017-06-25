package com.example.spring.controller;

/**
 * Created by tomidaat on 2017/06/26.
 */
import java.util.List;

import com.example.spring.dao.CustomerDAO;
import com.example.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerRestController {


    @Autowired
    private CustomerDAO customerDAO;


//    @GetMapping("/customers")
    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public List getCustomers() {
        return customerDAO.list();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {

        Customer customer = customerDAO.get(id);
        if (customer == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {

        customerDAO.create(customer);

        return new ResponseEntity(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {

        if (null == customerDAO.delete(id)) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

        customer = customerDAO.update(id, customer);

        if (null == customer) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }

}
