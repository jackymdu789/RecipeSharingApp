package com.recipe.recipes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Recipe> getRecipesByCategory(Integer categoryId) {
		return repo.findByCategoryCategoryId(categoryId);
	}

	public List<Recipe> findRecipesByIngredient(String ingredients) {
//        List<String> ingredientsList = Arrays.asList(ingredients.split(","));
		return repo.searchRecipeByIngredients(ingredients);
	}
}
