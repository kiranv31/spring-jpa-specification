package com.redhat.ws.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.redhat.ws.domain.Address;
import com.redhat.ws.domain.Customer;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long>, JpaSpecificationExecutor<Customer>{
}
