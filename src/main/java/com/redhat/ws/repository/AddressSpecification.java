package com.redhat.ws.repository;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import com.redhat.ws.domain.Address;
import com.redhat.ws.domain.Customer;

public final class AddressSpecification {

	public static Specification<Address> addressInCity(String city) {
	    return (address, cq, cb) -> cb.equal(address.get("city"), city);
	}
	 
	public static Specification<Address> livesInState(String state) {
	    return (address, cq, cb) -> cb.equal(address.get("state"), state);
	}
	
	public static Specification<Address> addressByPin(String pin) {
	    return (address, cq, cb) -> cb.equal(address.get("pin"), pin);
	}
	 
	public static Specification<Address> addresssOfCustomerHavingFirstName(String firstName) {
		return (address, cq, cb) -> {
			Join<Address, Customer> data = address.join("customer"); 
			return cb.equal(data.get("firstName"), firstName);
		};
    }
	
	public static Specification<Address> addresssOfCustomerHavingLastName(String lastName) {
		return (address, cq, cb) -> {
			Join<Address, Customer> data = address.join("customer"); 
			return cb.equal(data.get("lastName"), lastName);
		};
    }
}
