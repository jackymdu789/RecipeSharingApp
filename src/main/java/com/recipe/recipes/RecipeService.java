package com.recipe.recipes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.recipe.image.Image;
import com.recipe.image.ImageRepository;
import com.recipe.recipes.Recipe.PrivacyLevel;
import com.recipe.user.User;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository repo;
	@Autowired
	ImageRepository img;

	List<Recipe> getUserRecipesWithPublic() {
        return repo.findByPrivacyLevel(PrivacyLevel.PUBLIC);
	}
	
     List<Recipe> getUserRecipesWithPrivacy(User user) {
         return repo.findByPrivacyLevelAndUser(PrivacyLevel.PRIVATE, user);
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
	
	 public void addImageToRecipe(Integer recipeId, String fileName, String filePath) {
	        Recipe recipe = repo.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
	        Image image = new Image();
	        image.setRecipe(recipe);
	        image.setFileName(fileName);
	        image.setFilePath(filePath);
	        img.save(image);
	    }


}
