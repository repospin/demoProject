package com.example.demoProject.service.interfaces;

import java.util.List;

import com.example.demoProject.model.DTO.CustomerDTOreq;
import com.example.demoProject.model.DTO.CustomerDTOres;

public interface CustomerService {
	
	public CustomerDTOres saveCustomer(CustomerDTOreq customerDTOreq);
	public List<CustomerDTOres> findAllCustomer();
	public void checkIsPresentEmail(String email);
}
