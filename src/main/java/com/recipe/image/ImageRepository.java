package com.recipe.image;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
	
}
