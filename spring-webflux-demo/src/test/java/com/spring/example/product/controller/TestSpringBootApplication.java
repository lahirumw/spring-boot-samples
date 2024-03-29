package com.spring.example.product.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSpringBootApplication {

  @Autowired
  private ProductController controller;

  @Test
  public void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

}
