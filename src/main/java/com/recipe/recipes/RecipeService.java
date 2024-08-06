package com.recipe.recipes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository repo;

	List<Recipe> getAllRecipe() {
		return (List<Recipe>) repo.findAll();
	}

	Optional<Recipe> getRecipeById(Integer id) {
		return repo.findById(id);
	}

	public Recipe addRecipe(Recipe recipe) {
		// return repo.save(recipe).recipeId;
		return repo.save(recipe);
	}

	void deleteRecipeById(Integer id) {
		repo.deleteById(id);
	}

	List<Recipe> getRecipesByDuration(Integer duration) {
		return repo.findByDuration(duration);
	}

	public List<Recipe> getRecipesByCategory(Integer categoryId) {
		return repo.findByCategoryCategoryId(categoryId);
	}

	public List<Recipe> getRecipesByDietary(@RequestParam Integer dietaryId) {
		return repo.findByDietaryDietaryId(dietaryId);
	}

	public List<Recipe> findRecipesByIngredient(String ingredients) {
		return repo.searchRecipeByIngredients(ingredients);
	}
	public List<Recipe> getRecipesByServes(@RequestParam("serves") Integer serves) {
		return repo.findByServes(serves);
	}
}
