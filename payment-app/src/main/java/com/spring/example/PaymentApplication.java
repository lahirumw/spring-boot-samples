package com.spring.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PaymentApplication {

  public static void main(String[] args){
    SpringApplication.run(PaymentApplication.class, args);
  }

}

@RestController
@RequestMapping("/payment")
class PaymentController{

  @GetMapping(value = "/health")
  public String getPaymentHealth(){

    return "Payment Service is up and running.";
  }
}
