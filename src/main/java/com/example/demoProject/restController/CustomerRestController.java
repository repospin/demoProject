package com.example.demoProject.restController;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.model.DTO.CustomerDTOreq;
import com.example.demoProject.model.DTO.CustomerDTOres;
import com.example.demoProject.model.pojo.Email;
import com.example.demoProject.model.pojo.UserEntityGateway;
import com.example.demoProject.service.gateway.GatewayService;
import com.example.demoProject.service.interfaces.CustomerService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerRestController {
	
	private final CustomerService customerService;
	private final GatewayService gatewayService;
	
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTOres>> getAllCustomers() {
    	return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }
    
    @PostMapping("/customer/")
    public ResponseEntity<CustomerDTOres> getCustomerByEmail(@RequestBody @Valid Email email) {
    	return new ResponseEntity<>(customerService.findCustomerByEmail(email.getEmail()), HttpStatus.OK);
    }
    
    @PostMapping("/customer/save")
    public ResponseEntity<CustomerDTOres> saveCustomer(@RequestBody @Valid CustomerDTOreq customerDTOreq) {
    	return new ResponseEntity<>(customerService.saveCustomer(customerDTOreq), HttpStatus.CREATED);
    }
    
    @PutMapping("/customer/update")
    public ResponseEntity<CustomerDTOres> updateCustomer(@RequestParam BigDecimal id, @RequestBody @Valid CustomerDTOreq customerDTOreq) {
    	return new ResponseEntity<>(customerService.updateCustomer(id, customerDTOreq), HttpStatus.CREATED);
    }
    
    @GetMapping("/user/{id}")
    public Mono<ResponseEntity<UserEntityGateway>> getUserGateway(@PathVariable String id) {
    	 return gatewayService.getUserData(id)
                 .map(user -> ResponseEntity.ok(user))
                 .defaultIfEmpty(ResponseEntity.notFound().build()); 
    }

}
