package com.spring.example.product.controller;

import com.spring.example.product.domain.Product;
import com.spring.example.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(path = "/products/{productId}")
  public Mono<ResponseEntity<Product>> getProduct(@PathVariable String productId){

    return productService.getProduct(productId)
        .map(res -> ResponseEntity.status(HttpStatus.OK).body(res))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PostMapping(path = "/products")
  public Mono<ResponseEntity<Product>> createProduct(@RequestBody Product product){

    return productService.createProduct(product)
        .map(res -> ResponseEntity.status(HttpStatus.CREATED).body(res))
        .defaultIfEmpty(ResponseEntity.internalServerError().build());
  }

  @PutMapping(path = "/products/{productId}")
  public Mono<ResponseEntity<Product>> updateProduct(@PathVariable String productId, @RequestBody Product product){

    return productService.updateProduct(productId, product)
        .map(res -> ResponseEntity.status(HttpStatus.OK).body(res))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = "/products/{productId}")
  public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable String productId){

    return productService.deleteProduct(productId)
        .map(res -> ResponseEntity.noContent().build());
  }

  @GetMapping(path = "/products")
  public Flux<Product> getProducts(){
    return productService.getProducts();

  }
}
