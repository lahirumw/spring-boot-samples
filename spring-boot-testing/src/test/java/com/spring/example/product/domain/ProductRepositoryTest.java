package com.spring.example.product.domain;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  public void findByIdTest(){
    Product savedProduct = testEntityManager.persistAndFlush(new Product(1,"test"));

    Optional<Product> product = this.productRepository.findById(1);

    assertThat(product.get().getName()).isEqualTo(savedProduct.getName());
  }

  @Test
  public void saveTest(){
    Product product = this.productRepository.save(new Product(1, "test"));

    assertThat(product).isNotNull();
    assertThat(product.getName()).isEqualTo("test");

  }

  @Test
  public void deleteTest(){
    Product product = testEntityManager.persistAndFlush(new Product(1, "test"));

    assertThat(product).isNotNull();

    this.productRepository.deleteById(1);
    Optional<Product> result = this.productRepository.findById(1);

    assertThat(result.isEmpty()).isEqualTo(Boolean.TRUE);
  }

}
