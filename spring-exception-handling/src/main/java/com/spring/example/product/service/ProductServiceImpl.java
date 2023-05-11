package com.spring.example.product.service;

import com.spring.example.product.domain.Product;
import com.spring.example.product.exception.NotFoundException;
import com.spring.example.product.exception.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

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
  public Product getProduct(String productId) {
    if(PRODUCT_LIST.containsKey(productId)) {
      Product product = PRODUCT_LIST.get(productId);
      return product;
    }
    throw new NotFoundException("Product Not Found");
  }

  @Override
  public Product createProduct(Product product) {
    if(product.getProductId() != null) {
      PRODUCT_LIST.put(product.getProductId(), product);
      return product;
    }else{
      throw new ValidationException("ProductId is Mandatory");
    }
  }

}
