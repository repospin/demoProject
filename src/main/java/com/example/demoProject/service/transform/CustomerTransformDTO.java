package com.example.demoProject.service.transform;

import com.example.demoProject.model.DTO.CustomerDTOreq;
import com.example.demoProject.model.DTO.CustomerDTOres;
import com.example.demoProject.model.entity.Customer;

public class CustomerTransformDTO {

	public static Customer customerDTOReqToCustomer(CustomerDTOreq customerDTOreq) {
		Customer c = new Customer();
		c.setNome(customerDTOreq.getNome());
		c.setCognome(customerDTOreq.getCognome());
		c.setEmail(customerDTOreq.getEmail());
		return c;
	}
	
	public static CustomerDTOres customerToCustoemrDTOres(Customer customer) {
		CustomerDTOres c = new CustomerDTOres();
		c.setNome(customer.getNome());
		c.setCognome(customer.getCognome());
		c.setEmail(customer.getEmail());
		return c;
	}
}
