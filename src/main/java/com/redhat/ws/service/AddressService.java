package com.redhat.ws.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.redhat.ws.domain.Address;

@Service
public interface AddressService {
	public List<Address> getAllAddress();
	public Address findAddress(Long id);
	public Address addAddress(Address newCustomer);
	public boolean deleteAddress(Address deleteAddress);
	public Address updateCustomer(Address updateCustomer);
	public List<Address> getAddressBySpecification(Specification<Address> specs, Sort sort);
}
