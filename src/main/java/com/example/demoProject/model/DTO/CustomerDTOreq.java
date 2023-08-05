package com.example.demoProject.model.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CustomerDTOreq {
	
    @NotEmpty(message = "Il campo non può essere vuoto")
    @Pattern(regexp = "^[^0-9]*$", message = "Il campo non può contenere caratteri numerici")
	private String nome;
    
    @NotEmpty(message = "Il campo non può essere vuoto")
    @Pattern(regexp = "^[^0-9]*$", message = "Il campo non può contenere caratteri numerici")
	private String cognome;
    
    @Email
	private String email;
}
