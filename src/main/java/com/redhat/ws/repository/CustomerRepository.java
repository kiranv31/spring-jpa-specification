package com.redhat.ws.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.redhat.ws.domain.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
	default List<Customer> searchCustomers(Specification<Customer> spec, Sort sort){
		return findAll(spec, sort);
	}
}
