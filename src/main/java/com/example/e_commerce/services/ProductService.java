package com.example.e_commerce.services;

import java.util.List;

import com.example.e_commerce.domain.Product;
import com.example.e_commerce.dto.Productdto;

public interface ProductService {

	List<Product> getproductList();

	Productdto getProduct(String id);

	Productdto addProduct(Productdto product);

	Productdto updateproduct(Productdto product);

	String deleteProduct(String id);

}
