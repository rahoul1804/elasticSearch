package com.girmiti.controller;

import org.elasticsearch.client.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.girmiti.entity.Product;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestProductController {

	@LocalServerPort
    private int port;
	
	@Autowired
	ProductRepository repository;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();  

	
	@Test
	public void test2() {
		Product product = new Product();
		product.setId(8);
		product.setProductName("Samsung");
		product.setPrice("89");
		
		HttpEntity<Product> httpEntity = new HttpEntity<>(product, headers);
		ResponseEntity<Response> responseEntity = restTemplate.postForEntity("localhost:"+port+"/product/addProduct",
				httpEntity, Response.class);
		System.out.println(responseEntity);
	}
	
}
