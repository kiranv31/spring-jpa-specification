package com.redhat.ws.repository;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;
import com.redhat.ws.domain.Customer;
import com.redhat.ws.domain.Address;

public final class CustomerSpecification {

	public static Specification<Customer> hasFirstName(String firstName) {
	    return (customer, cq, cb) -> cb.equal(customer.get("firstName"), firstName);
	}
	 
	public static Specification<Customer> hasLastName(String lastName) {
	    return (customer, cq, cb) -> cb.equal(customer.get("lastName"), lastName);
	}
	
		
	public static Specification<Customer> livesInCity(String city) {
		return (customer, cq, cb) -> {
			Join<Customer, Address> data = customer.join("address"); 
			return cb.equal(data.get("city"), city);
		};
    }
	
	public static Specification<Customer> inState(String state) {
		return (customer, cq, cb) -> {
			Join<Customer, Address> data = customer.join("address"); 
			return cb.equal(data.get("state"), state);
		};
    }
	
	public static Specification<Customer> havingPin(String pin) {
		return (customer, cq, cb) -> {
			Join<Customer, Address> data = customer.join("address"); 
			return cb.equal(data.get("pin"), pin);
		};
    }
}
