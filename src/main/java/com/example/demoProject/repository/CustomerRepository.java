package com.example.demoProject.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demoProject.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, BigDecimal> {

    @Query("SELECT c.email FROM Customer c WHERE c.email = ?1")
	public String checkIsPresentEmail(String email);
    
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    public Optional<Customer> findCustomerByEmail(@Param("email") String email);

}
