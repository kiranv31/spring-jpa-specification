package com.redhat.ws.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.redhat.ws.domain.Address;
import com.redhat.ws.domain.Customer;
import com.redhat.ws.repository.AddressRepository;
import com.redhat.ws.repository.CustomerRepository;
import com.redhat.ws.repository.CustomerSpecification;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private CustomerRepository customerRepository;
	private AddressRepository addressRepository;

	public DevBootstrap(CustomerRepository customerRepository, AddressRepository addressRepository) {
		super();
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {

		// First
		Customer cus = new Customer();
		cus.setFirstName("Akash");
		cus.setLastName("Verma");

		Address address1 = new Address();
		address1.setCity("Pune");
		address1.setState("UP");
		address1.setPin("234567");

		Address address2 = new Address();
		address2.setCity("Kanpur");
		address2.setState("Maharastra");
		address2.setPin("144567");


		List<Address> address = new ArrayList<>();
		address.add(address1);
		address.add(address2);
		

		cus.setAddress(address);
		customerRepository.save(cus);

		address1.setCustomer(cus);
		address2.setCustomer(cus);

		addressRepository.save(address1);
		addressRepository.saveAll(address);

		// Second
		Customer cus1 = new Customer();
		cus1.setFirstName("Kiran");
		cus1.setLastName("Verma");
		

		Address add = new Address();
		add.setCity("Pune");
		add.setState("Karnataka");
		add.setPin("345123");

		List<Address> addsss = new ArrayList<>();
		addsss.add(add);

		cus1.setAddress(addsss);
		customerRepository.save(cus1);

		add.setCustomer(cus1);
		addressRepository.saveAll(addsss);

		// third
		Customer cus2 = new Customer();
		cus2.setFirstName("Vibha");
		cus2.setLastName("Verma");

		Address ad1 = new Address();
		ad1.setCity("ABC");
		ad1.setState("MP");
		ad1.setPin("788345");

		List<Address> ads = new ArrayList<>();
		ads.add(ad1);

		cus2.setAddress(addsss);
		customerRepository.save(cus2);

		ad1.setCustomer(cus2);
		addressRepository.saveAll(ads);
		
		Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
		
		
		// Testing repository
		List<Customer> cust = customerRepository.searchCustomers(CustomerSpecification.livesInCity("Pune").and(CustomerSpecification.hasLastName("Verma")),sort);
		System.out.println("size: "+cust.size());
		System.out.println("firstName: "+cust.get(0).getFirstName());
	}
}
