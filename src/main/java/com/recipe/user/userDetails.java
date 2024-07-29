package com.recipe.user;
import com.recipe.recipes.Recipe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class userDetails{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
Integer user_id;
String user_name;
String user_email;
String user_password;
@OneToMany
Recipe recipe;

public userDetails() {
	super();
}

public userDetails(Integer user_id, String user_name, String user_email, String user_password, Integer recipe_id) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.user_email = user_email;
	this.user_password = user_password;
	this.recipe = new Recipe(recipe_id);
}

public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_email() {
	return user_email;
}
public void setUser_email(String user_email) {
	this.user_email = user_email;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public Recipe getRecipe_id() {
	return recipe;
}
public Recipe setRecipe_id(Integer recipe_id) {
	return this.recipe = recipe;
}

}
