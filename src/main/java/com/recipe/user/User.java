package com.recipe.user;

import java.util.List;

import com.recipe.recipes.Recipe;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer userId;
	String userName;
	String userEmail;
	String userPassword;
	@OneToMany(targetEntity = Recipe.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "recipe_fk", referencedColumnName = "userId")
	private List<Recipe> recipes;

	public User() {
		super();
	}

	public User(String userName) {
		this.userName = userName;
	}

	public User(Integer userId, String userName, String userEmail, String userPassword, List<Recipe> recipes) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.recipes = recipes;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = (List<Recipe>) recipes;
	}

	@Override
	public String toString() {
		return "userDetails [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", recipe=" + recipes + "]";
	}
}
