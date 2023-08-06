package com.example.demoProject.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.model.DTO.CustomerDTOreq;
import com.example.demoProject.model.DTO.CustomerDTOres;
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
    
    @GetMapping("/customer/{email}")
    public ResponseEntity<CustomerDTOres> getCustomerByEmail(@PathVariable String email) {
    	return new ResponseEntity<>(customerService.findCustomerByEmail(email), HttpStatus.OK);
    }
    
    @PostMapping("/customer/save")
    public ResponseEntity<CustomerDTOres> saveCustomer(@RequestBody @Valid CustomerDTOreq customerDTOreq) {
    	customerService.checkIsPresentEmail(customerDTOreq.getEmail());
    	return new ResponseEntity<>(customerService.saveCustomer(customerDTOreq), HttpStatus.CREATED);
    }
    
    @GetMapping("/user/{id}")
    public Mono<ResponseEntity<UserEntityGateway>> getUserGateway(@PathVariable String id) {
    	 return gatewayService.getUserData(id)
                 .map(user -> ResponseEntity.ok(user))
                 .defaultIfEmpty(ResponseEntity.notFound().build()); 
    }

}
