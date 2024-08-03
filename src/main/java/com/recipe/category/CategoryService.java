package com.recipe.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repo;

	List<Category> findAllCategory() {
		return (List<Category>) repo.findAll();
	}

	public Optional<Category> findCategoryById(Integer categoryId) {
		return repo.findById(categoryId);
	}

	void addCategory(Category details) {
		repo.save(details);
	}

	void updateCategory(Integer id,Category details) {
		repo.save(details);
	}
	
	
}
