package com.demo.product.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.product.entity.Category;
import com.demo.product.entity.Product;
import com.demo.product.repository.ProductRespository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRespository productRespository;

	public ProductServiceImpl(ProductRespository productRespository) {
		this.productRespository = productRespository;
	}

	@Override
	public List<Product> listAllProduct() {
		return productRespository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		return productRespository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		product.setStatus("CREATED");
		product.setCreateAt(new Date());
		return productRespository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDB = getProduct(product.getId());
		if (productDB == null) {
			return null;
		}
		productDB.setName(product.getName());
		productDB.setDescription(product.getDescription());
		productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
		return productRespository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productDB = getProduct(id);
		if (productDB == null) {
			return null;
		}
		productDB.setStatus("ELIMINADO");
		return productRespository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category category) {
		return productRespository.findByCategory(category);
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		Product productDB = getProduct(id);
		if (productDB == null) {
			return null;
		}
		Double stock = productDB.getStock() + quantity;
		productDB.setStock(stock);
		return productRespository.save(productDB);
	}

}
