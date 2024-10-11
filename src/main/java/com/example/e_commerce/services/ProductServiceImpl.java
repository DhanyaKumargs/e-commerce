package com.example.e_commerce.services;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_commerce.domain.Product;
import com.example.e_commerce.dto.Productdto;
import com.example.e_commerce.exception.ProductExceptin;
import com.example.e_commerce.mongoRepository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepo;

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<Product> getproductList() {
		
		try {
			return productRepo.findAll();
			 
		} catch (Exception e) {
				throw new ProductExceptin(e.getMessage());
		}
		
	}

	@Override
	public Productdto getProduct(String id) {
		Objects.requireNonNull(id, "Request cannot be null");
		try {
			Product product = productRepo.findByid(id);
			return modelMapper.map(product, Productdto.class);
			 
		} catch (Exception e) {
				throw new ProductExceptin(e.getMessage());
		}
	}

	@Override
	public Productdto addProduct(Productdto productDto) {
		Objects.requireNonNull(productDto, "product Object cannot be null");
		try {
			Product product = modelMapper.map(productDto, Product.class);
			product = productRepo.save(product);
			return modelMapper.map(product, Productdto.class);
			 
			 
		} catch (Exception e) {
				throw new ProductExceptin(e.getMessage());
		}
	}

	@Override
	public Productdto updateproduct(Productdto productDto) {
		Objects.requireNonNull(productDto, "product Object cannot be null");
		try {
			Product product = modelMapper.map(productDto, Product.class);
			product = productRepo.save(product);
			return modelMapper.map(product, Productdto.class);
			 
			 
		} catch (Exception e) {
				throw new ProductExceptin(e.getMessage());
		}
	}

	@Override
	public String deleteProduct(String id) {
		Objects.requireNonNull(id, "Request cannot be null");
		try {
			productRepo.deleteByid(id);
			return "Product deleted Successfully";
		} catch (Exception e) {
			throw new ProductExceptin(e.getMessage());
		}
	}

}
