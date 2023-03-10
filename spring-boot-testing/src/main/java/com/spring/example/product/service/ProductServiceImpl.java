package com.spring.example.product.service;

import com.spring.example.product.domain.Product;
import com.spring.example.product.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  @Override
  public Product getProduct(int productId) {
     return productRepository.findById(productId)
         .orElseThrow(() -> new RuntimeException());

  }

  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(int productId) {
    productRepository.findById(productId)
        .orElseThrow(() ->new RuntimeException());

    productRepository.deleteById(productId);

  }
}
