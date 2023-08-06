package com.example.demoProject.model.pojo;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Email {
	
	@javax.validation.constraints.Email
	@NotNull
    @NotEmpty(message = "Il campo non può essere vuoto")
	private String email;
}
