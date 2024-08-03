package com.recipe.recipes;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
	List<Recipe> findByCategoryCategoryId(Integer categoryId);

	@Query(value = "select * from recipe.recipe where lower(ingredents) like %:ingredients%" , nativeQuery = true)
	List<Recipe> searchRecipeByIngredients(@Param("ingredients") String ingredients);
}

