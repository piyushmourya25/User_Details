package com.piyush.repository;

import org.springframework.data.repository.CrudRepository;

import com.piyush.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
