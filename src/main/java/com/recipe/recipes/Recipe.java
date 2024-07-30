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
	Integer category_id;
	Integer duration;
	@OneToOne
    @JoinColumn(name = "categoryId")
	Category cat;
	public Recipe() {
		
	}
	
	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}
	public Recipe(Integer recipe_id, String recipe_name, List<String> ingredents, String steps, Integer serves,
			Integer category_id, Integer duration, Category cat) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		this.ingredents = ingredents;
		this.steps = steps;
		this.serves = serves;
		this.category_id = category_id;
		this.duration = duration;
		this.cat = cat;
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

	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", ingredents=" + ingredents
				+ ", steps=" + steps + ", serves=" + serves + ", category_id=" + category_id + ", duration=" + duration
				+ ", cat=" + cat + "]";
	}	
	
}
