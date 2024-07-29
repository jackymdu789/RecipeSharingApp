package com.example.demo.category;

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
public Category(Integer category_id, String category_name) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}
public Integer getCategory_id() {
	return categoryId;
}
public void setCategory_id(Integer category_id) {
	this.categoryId = category_id;
}
public String getCategory_name() {
	return categoryName;
}
public void setCategory_name(String category_name) {
	this.categoryName = category_name;
}
@Override
public String toString() {
	return "categoryDetails [category_id=" + categoryId + ", category_name=" + categoryName + "]";
}

}
