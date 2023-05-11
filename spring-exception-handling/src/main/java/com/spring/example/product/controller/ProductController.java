package com.spring.example.product.controller;

import com.spring.example.product.domain.Product;
import com.spring.example.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(path = "/products/{productId}")
  public ResponseEntity<Product> getProduct(@PathVariable String productId){

    return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(productId));
  }

  @PostMapping(path = "/products")
  public ResponseEntity<Product> createProduct(@RequestBody Product product){

    return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));

  }

}
