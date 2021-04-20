package com.cc.productsandcategories.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cc.productsandcategories.models.Product;
import com.cc.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository prodRepo;
	public ProductService(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	public ArrayList<Product> getAll() {
		return (ArrayList<Product>) prodRepo.findAll();
	}
	
	public Product create(Product newProduct) {
		return prodRepo.save(newProduct);
	}

	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = prodRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;			
		}
	}
	
	public void deleteProduct(Long id) {
		prodRepo.deleteById(id);
	}
}
