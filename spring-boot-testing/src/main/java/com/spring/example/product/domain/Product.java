package com.spring.example.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "products")
public class Product {

  @Id
  @Column(name = "product_id")
  private int productId;

  @Column(name = "name")
  private String name;

  public Product(){

  }

  public Product(int productId, String name){
    this.productId = productId;
    this.name = name;

  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
