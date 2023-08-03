package com.example.demoProject.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty(message = "Il campo non può essere vuoto")
    @Pattern(regexp = "^[^0-9]*$", message = "Il campo non può contenere caratteri numerici")
    @Column()
    private String nome;
    
    @NotEmpty(message = "Il campo non può essere vuoto")
    @Pattern(regexp = "^[^0-9]*$", message = "Il campo non può contenere caratteri numerici")
    @Column()
    private String cognome;

    @Email
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
