package com.example.requesttracing.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class UserService {

    @Autowired
    private WebClient webClient;

    public Mono<ResponseEntity<String>> fetDummyUsersOnline() { //TODO: use a more specific class as against String (e.g. User)
        log.info("UserServing fetDummyUsersOnline");
        return webClient.get()
                .uri("/users?limit=5")
                .exchange()
                .flatMap(response -> response.toEntity(String.class));
    }
}