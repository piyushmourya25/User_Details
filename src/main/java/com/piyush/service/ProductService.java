package com.piyush.service;

import com.piyush.entity.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);

	Product saveProduct(Product product);
}
