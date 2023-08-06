package com.example.demoProject.service.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demoProject.exception.CustomExceptionGateway;
import com.example.demoProject.model.pojo.UserEntityGateway;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GatewayUserClient implements GatewayService {

    private final WebClient webClient;

    public Mono<UserEntityGateway> getUserData(String idUtente) {
    	try {
            return webClient.get()
	                .uri("/users/{id}", idUtente)
	                .retrieve()
	                .bodyToMono(UserEntityGateway.class);
    	}catch(Exception e){
    		throw new CustomExceptionGateway("Errore nella chiamata gateway: https://dummyjson.com/users/{id}");
    	}
    }
}
