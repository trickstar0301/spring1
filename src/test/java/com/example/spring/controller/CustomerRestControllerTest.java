//package com.example.spring.controller;
//
//import com.example.spring.dao.CustomerDAO;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//@RunWith(SpringRunner.class)
////@SpringBootTest(classes = Application.class)
////@WebAppConfiguration
//@AutoConfigureMockMvc
//public class CustomerRestControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private CustomerDAO customerDAO;
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void getCustomers() throws Exception {
////        when(this.customerDAO.get((long) 101)).thenReturn();
////        mvc.perform(get("/")).andExpect(status().isOk());
//
//    }
//
//}