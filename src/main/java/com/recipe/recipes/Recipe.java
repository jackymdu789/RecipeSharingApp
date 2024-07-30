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
	Integer recipe_id;
	String recipe_name;
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
	public Recipe(Integer recipe_id, String recipe_name, List<String> ingredents, String steps, Integer serves, Integer duration, Category category) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		this.ingredents = ingredents;
		this.steps = steps;
		this.serves = serves;
		this.duration = duration;
		this.category = category;
	}
	public Recipe(Integer recipe_id) {
		this.recipe_id = recipe_id;
	}
	public Integer getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(Integer recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
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
		return "Recipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", ingredents=" + ingredents
				+ ", steps=" + steps + ", serves=" + serves + ", duration=" + duration
				+ ", cat=" + category + "]";
	}	
	
}
