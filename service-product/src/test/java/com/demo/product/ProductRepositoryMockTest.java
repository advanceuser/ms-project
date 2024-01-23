package com.demo.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.product.entity.Category;
import com.demo.product.entity.Product;
import com.demo.product.repository.ProductRespository;

@DataJpaTest
class ProductRepositoryMockTest {

	@Autowired
	private ProductRespository productRespository;

	@Test
	void whenFindByCategoryThenReturnListProduct() {
		assertEquals(2, 2);

		Category category = new Category();
		category.setId(1L);
		category.setName("");

		Product producto = new Product();
		producto.setName("Computer");
		producto.setCategory(category);
		producto.setDescription("");
		producto.setStock(10d);
		producto.setPrice(1240.99);
		producto.setStatus("Created");
		producto.setCreateAt(new Date());

		productRespository.save(producto);
		List<Product> founds = productRespository.findByCategory(producto.getCategory());
		
		assertEquals(3, productRespository.findByCategory(category).size());
	}

}
