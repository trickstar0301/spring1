package com.example.spring.dao;

import com.example.spring.Application;
import com.example.spring.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CustomerDAOTest {
    @Autowired
    private CustomerDAO customerDAO;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getCustomerTest() throws Exception {
        Assert.isInstanceOf(Customer.class, customerDAO.get((long) 101));
    }
}