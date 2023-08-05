package com.example.demoProject.service.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
		return customerRepository.findAll().stream()
											.map(x -> CustomerTransformDTO.customerToCustoemrDTOres(x))
											.collect(Collectors.toList());
	}

}
