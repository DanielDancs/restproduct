package com.restproducts.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.restproducts.service.TestRestTemplateService;

@RestController
@RequestMapping(value="/api/product/")// produces= MediaType.APPLICATION_JSON_VALUE
public class ProductController {

	private ProductService productService;
	
	private TestRestTemplateService trservice;
	
	public ProductController(ProductService productService, TestRestTemplateService trservice) {
		this.productService = productService;
		this.trservice = trservice;
	}
	
	@GetMapping
	public List<Product> findAllProducts() {
		return productService.findAll();
	}
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@Validated @RequestBody Product product) {
		return productService.save(product);
	}
	
	@PostMapping(value="/upload", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public Product uploadData(@RequestPart("product") Product product, @RequestPart("file") MultipartFile mFile) {
		try {
			byte[] tomb = mFile.getBytes();
			File file = new File("src/main/resources/eredmeny.txt");
			OutputStream os = new FileOutputStream(file);
			os.write(tomb);
			os.flush();
			os.close();
		} catch (IOException e) {
			System.out.println("Probléma a file kiírásakor" + e.getMessage());
		}
//		Product productJson=productService.makeJson(product,file);
		productService.save(product);
		return product;
	}
	
//	@PreAuthorize("hasAuthority('ADMIN')")
//	@Secured("ROLE_ADMIN")
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
		Optional<Product> opt = productService.findById(id);
		if(opt.isPresent()) {
			productService.deleteById(id);
			return ResponseEntity.ok(Boolean.TRUE);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/outer")
	public ResponseEntity<?> getAnything(){
		trservice.listPapers();
		return null;
	}
	
	
}
