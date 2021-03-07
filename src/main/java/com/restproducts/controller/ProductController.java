package com.restproducts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restproducts.entities.Product;
import com.restproducts.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> findAllProducts() {
		return productService.findAll();
	}
	
	@PostMapping("/save")
	public Product saveProduct(@Validated @RequestBody Product product) {
		return productService.save(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
		Optional<Product> opt = productService.findById(id);
		if(opt.isPresent()) {
			productService.deleteById(id);
			return ResponseEntity.ok(opt.get());
		}else {
			return ResponseEntity.notFound().build();
		}
//		return ResponseEntity.of(opt);
	}
	
	
}
