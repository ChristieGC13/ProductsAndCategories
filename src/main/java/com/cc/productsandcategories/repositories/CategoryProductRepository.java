package com.cc.productsandcategories.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cc.productsandcategories.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

ArrayList<CategoryProduct> findAll();
	
	Optional<CategoryProduct> findById(Long id);
	
	CategoryProduct save(CategoryProduct catprod);
	
	void deleteById(Long id);
}
