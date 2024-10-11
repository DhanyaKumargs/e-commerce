package com.example.e_commerce.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce.domain.Product;
import com.example.e_commerce.dto.Productdto;
import com.example.e_commerce.services.ProductService;

@RestController
@RequestMapping("/product")
public class Productendpoint {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getProductlist(){
		
		return productService.getproductList();
		
	}
	
	@GetMapping("/get-product")
	public Productdto getProduct(@RequestParam("id") String id) {
		return productService.getProduct(id);
		
	}
	
	@PostMapping("/add-product")
	public Productdto addProduct(@RequestBody Productdto product) {
		return productService.addProduct(product);
		
	}
	
	@PutMapping("/update-product")
	public Productdto updateProduct(@RequestBody Productdto product) {
		return productService.updateproduct(product);
		
	}
	
	@DeleteMapping("/delete-product")
	public String deleteProduct(@RequestParam("id") String id) {
		return productService.deleteProduct(id);
		
	}

}
