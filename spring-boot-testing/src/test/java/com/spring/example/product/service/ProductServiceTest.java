package com.spring.example.product.service;

import com.spring.example.product.domain.Product;
import com.spring.example.product.domain.ProductRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.any;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  private ProductService productService;

  private Product responsePayload;


  @BeforeEach
  void setUp(){
    productService = new ProductServiceImpl(productRepository);
    responsePayload = new Product(1, "test");

  }

  @Test
  public void getProductTest(){

    when(productRepository.findById(any(Integer.class))).thenReturn(
        Optional.of(responsePayload));

    Product result = productService.getProduct(1);

    assertThat(result.getName()).isEqualTo(responsePayload.getName());
  }

  @Test
  public void createProduct(){

    when(productRepository.save(any(Product.class))).thenReturn(responsePayload);

    Product result = productService.createProduct(new Product(1, "test"));

    assertThat(result.getName()).isEqualTo(responsePayload.getName());
  }

  @Test
  public void deleteProductTest(){

    when(productRepository.findById(1)).thenReturn(Optional.of(responsePayload));
    doNothing().when(productRepository).deleteById(any(Integer.class));

    productService.deleteProduct(1);

    verify(productRepository).deleteById(1);
  }

  @Test
  public void deleteProductNotFoundTest(){

    when(productRepository.findById(1)).thenReturn(Optional.ofNullable(null));

    assertThrows(RuntimeException.class, () ->
        productService.deleteProduct(1));

  }
}
