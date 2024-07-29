package com.recipe.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<userDetails, Integer> {

//	Optional<userDetails> findById(Integer user_id);

}
