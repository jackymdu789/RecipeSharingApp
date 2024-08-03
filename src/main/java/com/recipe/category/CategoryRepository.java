package com.recipe.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

//	Optional<categoryDetails> findBycategoryDetailsCategoryId(Integer category_id);

}
