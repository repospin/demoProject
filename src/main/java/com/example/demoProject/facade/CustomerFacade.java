package com.example.demoProject.facade;

import java.math.BigDecimal;
import java.util.List;

import com.example.demoProject.model.DTO.CustomerDTOreq;
import com.example.demoProject.model.DTO.CustomerDTOres;
import com.example.demoProject.model.pojo.Email;

public interface CustomerFacade {

	public CustomerDTOres saveCustomerFacade(CustomerDTOreq customerDTOreq);
	public List<CustomerDTOres> findAllCustomerfFcade();
	public CustomerDTOres findCustomerByEmailFacade(Email email);
	public CustomerDTOres updateCustomerFacade(BigDecimal id, CustomerDTOreq customerDTOreq);
	public String deleteCustomerFacade(Email email);
}
