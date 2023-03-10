package com.spring.example.product.service;

import com.spring.example.product.domain.Product;

public interface ProductService {

  Product getProduct(int productId);

  Product createProduct(Product product);

  void deleteProduct(int productId);
}
