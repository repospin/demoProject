package com.example.demoProject.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demoProject.model.entity.Customer;
import com.example.demoProject.repository.CustomerRepository;

@Component
public class DataLoadeer implements ApplicationRunner{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Customer c = new Customer("Esempio", "Prova", "posta@email.com");
		Customer c2 = new Customer("Test", "Check", "xxx@email.com");

		customerRepository.save(c);
		customerRepository.save(c2);
	}
	
	
}
