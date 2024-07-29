package com.recipe.recipes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository repo;
	
	Iterable<Recipe> getAllRecipe() {
		return repo.findAll();
	}
	
	Optional<Recipe> getRecipeById(Integer id) {
		return repo.findById(id);
	}
	Recipe addRecipeById(Recipe recipe) {
		return repo.save(recipe);
	}
	
	void deleteRecipeById (Integer id) {
		repo.deleteById(id);
	}


}
