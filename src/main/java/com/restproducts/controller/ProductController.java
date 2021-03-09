package com.restproducts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restproducts.entities.Product;
import com.restproducts.service.ProductService;

@RestController
@RequestMapping(value="/api/product/")// produces= MediaType.APPLICATION_JSON_VALUE
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> findAllProducts() {
		return productService.findAll();
	}
	
	@PostMapping(value="/save", consumes= MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@Validated @RequestBody Product product) {
		return productService.save(product);
	}
	
	@PostMapping(value="/upload", consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public Product uploadData(@RequestPart("product") String product, @RequestPart("file") List<MultipartFile> file) {
		
		Product productJson=productService.makeJson(product,file);
		
		return productJson;
	}
	
//	egy deletnél még egy Boolean true/false is elég
//	tehát sikerült törölni vagy nem... minden egyébre meg dobunk vissza neki valami http error
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
