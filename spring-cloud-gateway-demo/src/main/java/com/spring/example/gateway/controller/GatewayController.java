package com.spring.example.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GatewayController {

  @GetMapping("/fallback")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Mono<String> getFallback() {
    return Mono.just("Error occurred");
  }

  @GetMapping("/health")
  public Mono<String> healthCheck() {
    return Mono.just("Gateway is up and running!");
  }
}
