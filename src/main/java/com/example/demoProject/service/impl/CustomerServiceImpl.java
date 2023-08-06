package com.example.demoProject.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demoProject.exception.CustomExceptionEmail;
import com.example.demoProject.model.DTO.CustomerDTOreq;
import com.example.demoProject.model.DTO.CustomerDTOres;
import com.example.demoProject.repository.CustomerRepository;
import com.example.demoProject.service.interfaces.CustomerService;
import com.example.demoProject.service.transform.CustomerTransformDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;

	@Override
	public CustomerDTOres saveCustomer(CustomerDTOreq customerDTOreq) {
		return CustomerTransformDTO.customerToCustoemrDTOres(customerRepository.save(CustomerTransformDTO.customerDTOReqToCustomer(customerDTOreq)));
	}

	@Override
	public List<CustomerDTOres> findAllCustomer() {
		return customerRepository.findAll().stream().
											map(customer -> CustomerTransformDTO.customerToCustoemrDTOres(customer))
											.collect(Collectors.toList());
	}

	@Override
	public void checkIsPresentEmail(String email) {
		if(customerRepository.checkIsPresentEmail(email) != null) {
			throw new CustomExceptionEmail("Errore: Email già presente nei nostri sistemi");
		}	
	}
	
	@Override
	public CustomerDTOres findCustomerByEmail(String email) {
		if(customerRepository.checkIsPresentEmail(email) == null) {
			throw new CustomExceptionEmail("Errore: Email non presente nei nostri sistemi");
		}
		return CustomerTransformDTO.customerToCustoemrDTOres(customerRepository.findCustomerByEmail(email).get(0));
	}
	
	

}
