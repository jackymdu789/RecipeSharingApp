package com.recipe.category;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CategoryController {
	@Autowired
	CategoryService service;

	@GetMapping("/")
	public List<Category> findAllCategory() {
		return service.findAllCategory();
	}

	@GetMapping("/{category_id}")
	public Optional<Category> findAllById(@PathVariable Integer categoryId) {
		return service.findCategoryById(categoryId);
	}
	
	@PostMapping("/")
	public void  addCategory(@RequestBody Category details) {
		service.addCategory(details);
	}
	@PutMapping("/{category_id}")
	public void updateCategory(@PathVariable Integer category_id,@RequestBody Category details) {
		service.updateCategory(category_id ,details);
	}
}
