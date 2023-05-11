package com.spring.example.product.service;

import com.spring.example.product.domain.Product;
import java.util.Optional;

public interface ProductService {

  Product getProduct(String productId);

  Product createProduct(Product product);

}
