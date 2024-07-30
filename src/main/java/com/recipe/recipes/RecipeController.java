package com.recipe.recipes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
	@Autowired
	RecipeService service;

	@GetMapping("/recipe")
	Iterable<Recipe> getAllRecipe() {
		return service.getAllRecipe();
	}
@GetMapping("/recipe/{id}")
	Optional<Recipe> getRecipeById(@PathVariable Integer id) {
		return service.getRecipeById(id);
	}
@PostMapping("/recipe")
	Recipe addRecipeById(@RequestBody Recipe recipe) {
		return service.addRecipeById(recipe);
	}
@DeleteMapping("/recipe/{id}")
	void deleteRecipeById(@PathVariable Integer id) {
		service.deleteRecipeById(id);
	}
@GetMapping("/{ingredents}")
void searchByIngredents(@PathVariable List<String> ingredents) {
	service.searchByIngredents(ingredents);
}
}
