package com.restproducts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restproducts.entities.Product;
import com.restproducts.repo.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepo;
	
	@Autowired
	public ProductService (ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Product save(Product product) {
		return productRepo.save(product);
	}

	public Optional<Product> findById(Long id) {
		return productRepo.findById(id);
	}

	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}	
}
