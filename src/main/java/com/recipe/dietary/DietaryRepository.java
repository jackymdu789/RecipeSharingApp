package com.recipe.dietary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DietaryRepository extends  CrudRepository<Dietary, Integer> {
	
}
