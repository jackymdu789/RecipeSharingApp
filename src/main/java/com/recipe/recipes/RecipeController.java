package com.recipe.recipes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.category.Category;
import com.recipe.category.CategoryService;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class RecipeController {
	@Autowired
	RecipeService service;
	@Autowired
	CategoryService cservice;

	@GetMapping("/recipe")
	List<Recipe> getAllRecipe() {
		return service.getAllRecipe();
	}

	@GetMapping("/recipe/{id}")
	Optional<Recipe> getRecipeById(@PathVariable Integer id) {
		return service.getRecipeById(id);
	}

	@PostMapping("/recipe")
	Recipe addRecipe(@RequestBody Recipe recipe) {
		return service.addRecipe(recipe);
	}

	@DeleteMapping("/recipe/{id}")
	void deleteRecipeById(@PathVariable Integer id) {
		service.deleteRecipeById(id);
	}

	@GetMapping("recipe/bycategory")
	public List<Recipe> getRecipesByCategory(@RequestParam Integer categoryId) {
		return service.getRecipesByCategory(categoryId);
	}

	@PostMapping("/createrecipe")
	public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
		Optional<Category> categoryOpt = cservice.findCategoryById(recipe.getCategory().getCategoryId());
		if (categoryOpt.isPresent()) {
			recipe.setCategory(categoryOpt.get());
		} else {
			return ResponseEntity.badRequest().body(null);
		}
		Recipe createdRecipe = service.addRecipe(recipe);
		return ResponseEntity.ok(createdRecipe);
	}

	@GetMapping("/recipe/search")
	public List<Recipe> findRecipesByIngredient(@RequestParam("ingredients") String ingredients) {

		return service.findRecipesByIngredient(ingredients);
	}

}
