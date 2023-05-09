package com.spring.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BookingApplication {

  public static void main(String args[]){
    SpringApplication.run(BookingApplication.class, args);
  }

}

@RestController
@RequestMapping("/booking")
class BookingController{

  @GetMapping(value = "/health")
  public String getBookingHealth(){
    return "Booking Service is up and running.";

  }
}
