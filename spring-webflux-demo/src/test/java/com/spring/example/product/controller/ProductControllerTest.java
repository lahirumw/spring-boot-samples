package com.spring.example.product.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.spring.example.product.domain.Product;
import com.spring.example.product.service.ProductService;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ProductController.class)
public class ProductControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  @MockBean
  ProductService productService;

  @Test
  public void getProductTest(){

    Product product = new Product("1", "test");

    when(this.productService.getProduct(any(String.class))).thenReturn(Mono.just(product));
    WebTestClient.ResponseSpec response = webTestClient.get()
        .uri("/products/{productId}", Collections.singletonMap("productId", "1"))
        .exchange();

    response.expectStatus().isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.productId").isEqualTo(product.getProductId())
        .jsonPath("$.name").isEqualTo(product.getName());
  }

  @Test
  public void getProductTest_notfound(){

    when(this.productService.getProduct(any(String.class))).thenReturn(Mono.empty());
    WebTestClient.ResponseSpec response = webTestClient.get()
        .uri("/products/{productId}", Collections.singletonMap("productId", "1"))
        .exchange();

    response.expectStatus().isNotFound()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  public void createProductTest(){

    Product product = new Product("1", "test");

    when(this.productService.createProduct(any(Product.class))).thenReturn(Mono.just(product));
    WebTestClient.ResponseSpec response = webTestClient.post()
        .uri("/products")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(product), Product.class)
        .exchange();

    response.expectStatus().isCreated()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.productId").isEqualTo(product.getProductId())
        .jsonPath("$.name").isEqualTo(product.getName());
  }

  @Test
  public void createProductTest_error(){

    Product product = new Product("1", "test");

    when(this.productService.createProduct(any(Product.class))).thenReturn(Mono.empty());
    WebTestClient.ResponseSpec response = webTestClient.post()
        .uri("/products")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(product), Product.class)
        .exchange();

    response.expectStatus().is5xxServerError()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  public void deleteProductTest(){

    Product product = new Product("1", "test");
    when(this.productService.deleteProduct(any(String.class))).thenReturn(Mono.just(product));
    WebTestClient.ResponseSpec response = webTestClient.delete()
        .uri("/products/{productId}", Collections.singletonMap("productId", "1"))
        .exchange();

    response.expectStatus().isNoContent()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  public void updateProductTest(){

    Product product = new Product("1", "test");
    when(this.productService.updateProduct(any(String.class), any(Product.class))).thenReturn(Mono.just(product));
    WebTestClient.ResponseSpec response = webTestClient.put()
        .uri("/products/{productId}", Collections.singletonMap("productId", "1"))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(product), Product.class)
        .exchange();

    response.expectStatus().isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.productId").isEqualTo(product.getProductId())
        .jsonPath("$.name").isEqualTo(product.getName());
  }
}
