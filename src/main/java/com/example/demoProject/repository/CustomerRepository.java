package com.example.demoProject.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoProject.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, BigDecimal> {

}
