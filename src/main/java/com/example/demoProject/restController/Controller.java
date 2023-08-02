package com.example.demoProject.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.model.entity.Customer;
import com.example.demoProject.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private CustomerRepository customerRepository;
	
    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
    
//    @GetMapping()
//    public void addCustomer() {
//		Customer c = new Customer("Esempio", "Prova", "posta@email.com");
//		customerRepository.save(c);    
//	}

}
