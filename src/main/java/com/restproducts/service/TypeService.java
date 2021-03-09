package com.restproducts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restproducts.entities.Type;
import com.restproducts.repo.TypeRepository;

@Service
public class TypeService {
	
	private TypeRepository typeRepo;
	
	public TypeService (TypeRepository typeRepo) {
		this.typeRepo = typeRepo;
	}

	public List<Type> findAll() {
		return typeRepo.findAll();
	}

	public Type save(Type type) {
		return typeRepo.save(type);
	}

	public Optional<Type> findById(Long id) {
		return typeRepo.findById(id);
	}

	public void deleteById(Long id) {
		typeRepo.deleteById(id);
	}
}
