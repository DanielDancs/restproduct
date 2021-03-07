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

import com.restproducts.entities.Type;
import com.restproducts.service.TypeService;

@RestController
@RequestMapping("api/type")
public class TypeController {

	private TypeService typeService;

	@Autowired
	public TypeController(TypeService typeService) {
		this.typeService = typeService;
	}

	@GetMapping
	public List<Type> findAllTypes() {
		return typeService.findAll();
	}
	
	@PostMapping("/save")
	public Type saveType(@Validated @RequestBody Type type) {
		return typeService.save(type);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Type> deleteType(@PathVariable Long id){
		Optional<Type> optType = typeService.findById(id);
		if(optType.isPresent()) {
			typeService.deleteById(id);
			return ResponseEntity.ok(optType.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
