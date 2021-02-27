package com.restproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restproducts.entities.Product;
import com.restproducts.repo.ProductRepository;

@RestController
@RequestMapping(value="/api/product")
public class ProductController {

	private ProductRepository productRepo;
	
	@Autowired
	public ProductController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@GetMapping
	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}
}
