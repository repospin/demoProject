package com.example.demoProject.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;
    
    @Column()
    private String nome;
    
    @Column()
    private String cognome;

    @Column(unique = true)
    private String email;
	
	public Customer() {

	}
	
	public Customer( String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}


    
    
}
