package com.restproducts.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restproducts.entities.Paper;

@Service
public class TestRestTemplateService {
	
	private RestTemplate restTemplate;
	
	public TestRestTemplateService() {
		this.restTemplate = new RestTemplate();
	}
		
	String source = "https://reqres.in/api/users?page=2";
	
	public void listPapers() {
		ResponseEntity<Paper> forEntity = restTemplate.getForEntity(source,Paper.class);
		
//		HttpStatus statusCode = forEntity.getStatusCode();
//		if(HttpStatus.OK.equals(statusCode)) {
//		}else if(HttpStatus.NOT_FOUND.equals(statusCode)) {
//		}
//		statusCode.is4xxClientError();
		
		System.out.println(forEntity.getBody());
	}
}
