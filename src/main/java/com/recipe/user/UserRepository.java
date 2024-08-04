package com.recipe.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUserName(String userName);
	Optional<User> findByUserEmail(String userEmail);
}
