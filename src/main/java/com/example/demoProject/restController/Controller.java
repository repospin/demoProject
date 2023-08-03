package com.example.demoProject.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Customer customer) {
    	Customer savedUser = customerRepository.save(customer);
    	return new ResponseEntity<>("Customer salvato con successo con ID: " + savedUser.getId(), HttpStatus.CREATED);
    }

}
