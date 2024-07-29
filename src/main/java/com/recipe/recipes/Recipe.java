package com.recipe.recipes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recipe {
	@Id
	Integer recipe_id;
	String recipe_name;
	String Ingredents;
	String procedure;
	Integer serves;
	Integer category_id;
	Integer duration;
	
	public Recipe() {
		
	}
	
	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", Ingredents=" + Ingredents
				+ ", procedure=" + procedure + ", serves=" + serves + ", category_id=" + category_id + ", duration="
				+ duration + "]";
	}
	public Recipe(Integer recipe_id, String recipe_name, String ingredents, String procedure, Integer serves,
			Integer category_id, Integer duration) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		this.Ingredents = ingredents;
		this.procedure = procedure;
		this.serves = serves;
		this.category_id = category_id;
		this.duration = duration;
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
	public String getIngredents() {
		return Ingredents;
	}
	public void setIngredents(String ingredents) {
		Ingredents = ingredents;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public Integer getServes() {
		return serves;
	}
	public void setServes(Integer serves) {
		this.serves = serves;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
}
