package com.spring.example.product.controller;

import com.spring.example.product.domain.Product;
import com.spring.example.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{productId}")
  public Product getProduct(@PathVariable int productId){
    return productService.getProduct(productId);
  }

  @PostMapping
  public Product createProduct(@RequestBody Product product){
    return productService.createProduct(product);
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable int productId){
    productService.deleteProduct(productId);
    return ResponseEntity.noContent().build();
  }
}
