package com.recipe.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
Integer categoryId;
String categoryName;

public Category() {
	super();
}
public Category(Integer categoryId, String categoryName) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}

public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
@Override
public String toString() {
	return "categoryDetails [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
}

}
