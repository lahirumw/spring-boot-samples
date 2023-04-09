package com.spring.example.product.service;

import com.spring.example.product.domain.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

  private static Map<String, Product> PRODUCT_LIST = new HashMap<>();

  public ProductServiceImpl(){
    Product product1 = new Product("1", "Test 1");
    PRODUCT_LIST.put("1", product1);
    Product product2 = new Product("2", "Test 2");
    PRODUCT_LIST.put("2", product2);
  }

  @Override
  public Mono<Product> getProduct(String productId) {
    if(PRODUCT_LIST.containsKey(productId)) {
      Product product = PRODUCT_LIST.get(productId);
      return Mono.just(product);
    }
    return Mono.empty();
  }

  @Override
  public Mono<Product> createProduct(Product product) {
    PRODUCT_LIST.put(product.getProductId(), product);
    return Mono.just(product);
  }

  @Override
  public Mono<Product> updateProduct(String productId, Product product){

    if(PRODUCT_LIST.containsKey(productId)) {
      return Mono.just(PRODUCT_LIST.replace(productId, product));
    }
    return Mono.empty();
  }

  @Override
  public Mono<Product> deleteProduct(String productId) {
    if(PRODUCT_LIST.containsKey(productId)) {
      return Mono.just(PRODUCT_LIST.remove(productId));
    }
    return Mono.empty();
  }

  @Override
  public Flux<Product> getProducts(){
    return Flux.fromStream(PRODUCT_LIST.values().parallelStream());
  }
}
