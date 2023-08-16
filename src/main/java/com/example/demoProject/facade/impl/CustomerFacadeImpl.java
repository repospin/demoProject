package com.example.demoProject.facade.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demoProject.facade.CustomerFacade;
import com.example.demoProject.model.DTO.CustomerDTOreq;
import com.example.demoProject.model.DTO.CustomerDTOres;
import com.example.demoProject.model.pojo.Email;
import com.example.demoProject.service.interfaces.CustomerService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerFacadeImpl implements CustomerFacade {

	private final CustomerService customerService;

	@Override
	public CustomerDTOres saveCustomerFacade(CustomerDTOreq customerDTOreq) {
		return customerService.saveCustomer(customerDTOreq);
	}

	@Override
	public List<CustomerDTOres> findAllCustomerfFcade() {
		return customerService.findAllCustomer();
	}

	@Override
	public CustomerDTOres findCustomerByEmailFacade(Email email) {
		return customerService.findCustomerByEmail(email.getEmail());
	}

	@Override
	public CustomerDTOres updateCustomerFacade(BigDecimal id, CustomerDTOreq customerDTOreq) {
		return customerService.updateCustomer(id, customerDTOreq);
	}

	@Override
	public String deleteCustomerFacade(Email email) {
		return customerService.deleteCustomer(email.getEmail());
	}

}
