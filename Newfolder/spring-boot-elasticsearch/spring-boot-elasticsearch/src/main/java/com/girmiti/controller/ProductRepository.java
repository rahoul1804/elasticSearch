package com.girmiti.controller;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.girmiti.entity.Product;

@Repository
interface ProductRepository extends ElasticsearchRepository<Product, Integer> {
}
