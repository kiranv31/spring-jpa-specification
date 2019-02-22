package com.redhat.ws.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.redhat.ws.domain.Address;
import com.redhat.ws.domain.Customer;

@Service
public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer findCustomer(Long id);
	public Customer addCustomer(Customer newCustomer);
	public boolean deleteCustomer(Customer deleteCustomer);
	public Customer updateCustomer(Customer updateCustomer);
	public List<Customer> searchCustomers(Specification<Address> specs, Sort sort);
}

