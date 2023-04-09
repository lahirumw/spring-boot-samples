package com.spring.example.product.service;

import com.spring.example.product.domain.Product;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

  Mono<Product> getProduct(String productId);

  Mono<Product> createProduct(Product product);

  Mono<Product> updateProduct(String productId, Product product);

  Mono<Product> deleteProduct(String productId);

  Flux<Product> getProducts();

}
