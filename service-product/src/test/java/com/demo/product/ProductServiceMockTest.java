package com.demo.product;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.product.entity.Category;
import com.demo.product.entity.Product;
import com.demo.product.repository.ProductRespository;
import com.demo.product.service.ProductService;
import com.demo.product.service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductServiceMockTest {

	@Mock
	private ProductRespository productRespository;
	private ProductService productService;

	@BeforeEach
	void setUp() {

		productService = new ProductServiceImpl(productRespository);

		Category category = new Category();
		category.setId(1L);

		Product product = new Product();
		product.setId(1L);
		product.setName("Computer");
		product.setCategory(category);
		product.setPrice(12.5);
		product.setStock(5d);

		Mockito.when(productRespository.findById(1L)).thenReturn(Optional.of(product));
		//Mockito.when(productRespository.save(product)).thenReturn(product);
	}

	@Test
	void testValidaGetIdThenReturnProduct() {
		Product product1 = productService.getProduct(1L);
		Assertions.assertEquals("Computer", product1.getName());
	}

	@Test
	void testValidaIncremento() {
		Product product2 = productService.updateStock(1L, 8d);
		Assertions.assertEquals(13, product2.getStock());
	}

}
