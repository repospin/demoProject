package com.example.demoProject.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demoProject.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, BigDecimal> {

    @Query("SELECT c.email FROM Customer c WHERE c.email = ?1")
	public String checkIsPresentEmail(String email);

}
