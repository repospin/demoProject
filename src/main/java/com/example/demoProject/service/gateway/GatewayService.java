package com.example.demoProject.service.gateway;

import com.example.demoProject.model.pojo.UserEntityGateway;

import reactor.core.publisher.Mono;

public interface GatewayService {

	public Mono<UserEntityGateway> getUserData(String idUtente);
	public Mono<String> getUserDataPost(String idUtente);
}
