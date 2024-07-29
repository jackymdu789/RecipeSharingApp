package com.example.demo.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.user.userDetails;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repo;

	List<Category> findAllCategory() {
		return (List<Category>) repo.findAll();
	}

	Optional<Category> findCategoryById(Integer categoryId) {
		return repo.findById(categoryId);
	}

	void addCategory(Category details) {
		repo.save(details);
	}

	void updateCategory(Integer id,Category details) {
		repo.save(details);
	}
}
