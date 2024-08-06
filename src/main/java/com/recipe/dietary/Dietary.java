package com.recipe.dietary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dietary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
Integer dietaryId;
String dietaryName;

public Dietary() {
	super();
}
public Dietary(Integer dietaryId, String dietaryName) {
	super();
	this.dietaryId = dietaryId;
	this.dietaryName = dietaryName;
}
public Integer getDietaryId() {
	return dietaryId;
}
public void setDietaryId(Integer dietaryId) {
	this.dietaryId = dietaryId;
}
public String getDietaryName() {
	return dietaryName;
}
public void setDietaryName(String dietaryName) {
	this.dietaryName = dietaryName;
}
@Override
public String toString() {
	return "Dietary [dietaryId=" + dietaryId + ", dietaryName=" + dietaryName + "]";
}

}
