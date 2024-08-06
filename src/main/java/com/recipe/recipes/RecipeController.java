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
import com.recipe.dietary.Dietary;
import com.recipe.dietary.DietaryService;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class RecipeController {
	@Autowired
	RecipeService service;
	@Autowired
	CategoryService cservice;
	@Autowired
	DietaryService dservice;

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

	@GetMapping("recipe/bydietary")
	public List<Recipe> getRecipesByDietary(@RequestParam Integer dietaryId) {
		return service.getRecipesByDietary(dietaryId);
	}

	@GetMapping("/recipe/search")
	public List<Recipe> findRecipesByIngredient(@RequestParam("ingredients") String ingredients) {
		return service.findRecipesByIngredient(ingredients);
	}

	@GetMapping("/recipe/byduration")
	List<Recipe> getRecipesByDuration(@RequestParam("duration") Integer duration) {
		return service.getRecipesByDuration(duration);
	}

	@GetMapping("/recipe/byserves")
	List<Recipe> getRecipesByServes(@RequestParam("serves") Integer serves) {
		return service.getRecipesByServes(serves);
	}

	@PostMapping("/recipe/{userId}/createRecipe")
	public ResponseEntity<Recipe> createRecipe(@PathVariable Integer userId, @RequestBody Recipe recipe) {
		System.out.println("Received recipe: " + recipe);

		if (recipe.getCategory() == null || recipe.getCategory().getCategoryId() == null) {
			return ResponseEntity.badRequest().body(null);
		}
		if (recipe.getDietary() == null || recipe.getDietary().getDietaryId() == null) {
			return ResponseEntity.badRequest().body(null);
		}

		Optional<Category> categoryOpt = cservice.findCategoryById(recipe.getCategory().getCategoryId());
		Optional<Dietary> dietaryOpt = dservice.getDietaryById(recipe.getDietary().getDietaryId());

		if (!categoryOpt.isPresent() || !dietaryOpt.isPresent()) {
			return ResponseEntity.badRequest().body(null);
		}

		recipe.setCategory(categoryOpt.get());
		recipe.setDietary(dietaryOpt.get());

		Recipe createdRecipe = service.addRecipe(recipe);
		return ResponseEntity.ok(createdRecipe);
	}

}