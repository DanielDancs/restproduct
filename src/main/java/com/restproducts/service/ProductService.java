package com.restproducts.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restproducts.entities.Product;
import com.restproducts.repo.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepo;
	
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

	public Product makeJson(String product, List<MultipartFile> file) {
		Product productJson = new Product();
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			productJson = objectMapper.readValue(product, Product.class);
		} catch (JsonMappingException e) {
			System.out.println("OwnError: " + e.getMessage());
		} catch (JsonProcessingException e) {
			System.out.println("OwnError: " + e.getMessage());
		}
		
		return productJson;
	}
	
}
