package com.spring.example.product.controller;

import com.spring.example.product.domain.Product;
import com.spring.example.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  private Product product;
  private String requestPayload;

  @BeforeEach
  void setUp(){
    product = new Product(1, "test");
    requestPayload = "{\n"
        + "    \"productId\": 1,\n"
        + "    \"name\": \"test\"\n"
        + "}";
  }


  @Test
  public void getProductTest() throws Exception {

    when(this.productService.getProduct(any(Integer.class))).thenReturn(product);

    this.mockMvc.perform(get("/product/{productId}", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("test"));
  }

  @Test
  public  void createProductTest() throws Exception {

    when(this.productService.createProduct(any(Product.class))).thenReturn(product);

    this.mockMvc.perform(post("/product")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(requestPayload))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("test"));
  }

  @Test
  public void deleteProductTest() throws Exception {
    doNothing().when(this.productService).deleteProduct(any(Integer.class));

    this.mockMvc.perform(delete("/product/{productId}", 1))
        .andExpect(status().isNoContent());
  }
}
