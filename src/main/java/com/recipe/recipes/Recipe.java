package com.recipe.recipes;

import java.util.List;
import com.recipe.category.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer recipeId;
	String recipeName;
	private List <String> ingredents;
	String steps;
	Integer serves;
	Integer duration;
	@OneToOne
    @JoinColumn(name = "categoryId")
	Category category;
	public Recipe() {
		
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public Recipe(Integer recipeId, String recipeName, List<String> ingredents, String steps, Integer serves, Integer duration, Category category) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.ingredents = ingredents;
		this.steps = steps;
		this.serves = serves;
		this.duration = duration;
		this.category = category;
	}
	public Recipe(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public Integer getrecipeId() {
		return recipeId;
	}
	public void setRecipe_id(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public String getrecipeName() {
		return recipeName;
	}
	public void setRecipe_name(String recipeName) {
		this.recipeName = recipeName;
	}
	public List<String> getIngredents() {
		return ingredents;
	}
	public void setIngredents(List<String> ingredents) {
		this.ingredents = ingredents;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public Integer getServes() {
		return serves;
	}
	public void setServes(Integer serves) {
		this.serves = serves;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipeId + ", recipe_name=" + recipeName + ", ingredents=" + ingredents
				+ ", steps=" + steps + ", serves=" + serves + ", duration=" + duration
				+ ", cat=" + category + "]";
	}	
	
}
