package com.recipe.recipes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.recipe.category.Category;
import com.recipe.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer recipeId;
	String recipeName;
	private List<String> ingredients;
	String steps;
	Integer serves;
	Integer duration;
	@ManyToOne
	@JsonBackReference
	User user;
	@OneToOne
//	@JoinColumn(name = "categoryId")
	Category category;
	public Recipe() {

	}


	public Recipe(Integer recipeId, String recipeName, List<String> ingredients, String steps, Integer serves,
			Integer duration, User user, Category category) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.ingredients = ingredients;
		this.steps = steps;
		this.serves = serves;
		this.duration = duration;
		this.user = user;
		this.category = category;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public List<String> getingredients() {
		return ingredients;
	}

	public void setingredients(List<String> ingredients) {
		this.ingredients = ingredients;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", ingredients=" + ingredients + ", steps="
				+ steps + ", serves=" + serves + ", duration=" + duration + ", user=" + user + ", category=" + category
				+ "]";
	}
	

}
