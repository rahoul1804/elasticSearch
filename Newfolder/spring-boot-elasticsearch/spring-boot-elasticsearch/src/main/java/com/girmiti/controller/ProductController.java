package com.girmiti.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.entity.Product;


@RestController
public class ProductController {

	@Autowired
	ProductRepository repository;

	@GetMapping("/")
	public List<Product> welcome() {
		Iterator<Product> iterator = repository.findAll().iterator();
		List<Product> products = new ArrayList<Product>();
		while (iterator.hasNext()) {
			products.add(iterator.next());
		}
		return products;
	}
	
	@PostMapping("/product/addProduct")
	public Product addStudent(@RequestBody Product product) {
		return repository.save(product);
	}

	@GetMapping("/product/getAllProducts")
	public List<Product> getStudents() {
		Iterator<Product> iterator = repository.findAll().iterator();
		List<Product> products = new ArrayList<Product>();
		while (iterator.hasNext()) {
			products.add(iterator.next());
		}
		return products;
	}

	@GetMapping("/product/{id}")
	public Optional<Product> getStudent(@PathVariable Integer id) {
		return repository.findById(id);
	}

	@PutMapping("/product/{id}")
	public Product updateStudent(@PathVariable Integer id, @RequestBody Product product) {
		Optional<Product> std = repository.findById(id);
		if (std.isPresent()) {
			Product s = std.get();
			s.setProductName(product.getProductName());
			return repository.save(s);
		} else
			return null;
	}

	@DeleteMapping("/product/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		repository.deleteById(id);
		return "Product " + id + " Document Deleted";
	}

}
