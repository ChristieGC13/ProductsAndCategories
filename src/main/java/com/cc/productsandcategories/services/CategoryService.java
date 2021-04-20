package com.cc.productsandcategories.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cc.productsandcategories.models.Category;
import com.cc.productsandcategories.models.CategoryProduct;
import com.cc.productsandcategories.repositories.CategoryProductRepository;
import com.cc.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository catRepo;
	private CategoryProductRepository catProdRepo;
	public CategoryService(CategoryRepository catRepo, CategoryProductRepository catProdRepo) {
		this.catRepo = catRepo;
		this.catProdRepo = catProdRepo;
	}
	
	public ArrayList<Category> getAll() {
		return (ArrayList<Category>) catRepo.findAll();
	}
	
	public Category create(Category newCategory) {
		return catRepo.save(newCategory);
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = catRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;			
		}
	}
	
	public CategoryProduct saveRelationship(CategoryProduct catprod) {
		return catProdRepo.save(catprod);
	}
	
	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
	}
}
