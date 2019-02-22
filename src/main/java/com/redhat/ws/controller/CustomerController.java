package com.redhat.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.ws.domain.Customer;
import com.redhat.ws.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
//	@Autowired
//	public CustomerService customerService;
//	
//	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
//	public List<Customer> getCustomers() {
//		return customerService.getAllCustomers();
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
//	public Customer createCustomer(Customer customer) {
//		return customerService.addCustomer(customer);
//	}
//	
//	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
//	public boolean createCustomer(long customerId) {
//		Customer cust = customerService.findCustomer(customerId);
//		return customerService.deleteCustomer(cust);
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
//	public Customer updateCustomer(Customer customer) {
//		return customerService.updateCustomer(customer);
//	}	
//	
}
