package com.recipe.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CategoryController {
	@Autowired
	CategoryService service;

	@GetMapping("/category")
	public List<Category> findAllCategory() {
		return service.findAllCategory();
	}

	@GetMapping("/category/{category_id}")
	public Optional<Category> findAllById(@PathVariable Integer categoryId) {
		return service.findCategoryById(categoryId);
	}
	
	@PostMapping("/category")
	public void  addCategory(@RequestBody Category details) {
		service.addCategory(details);
	}
	@PutMapping("/category/{category_id}")
	public void updateCategory(@PathVariable Integer category_id,@RequestBody Category details) {
		service.updateCategory(category_id ,details);
	}
}
