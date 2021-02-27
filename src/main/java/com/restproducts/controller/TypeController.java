package com.restproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restproducts.entities.Type;
import com.restproducts.repo.TypeRepository;

@RestController
@RequestMapping("api/type")
public class TypeController {

	private TypeRepository typeRepository;

	@Autowired
	public TypeController(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	@GetMapping
	public List<Type> findAllTypes() {
		return typeRepository.findAll();
	}
}
