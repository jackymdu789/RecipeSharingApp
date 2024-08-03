package com.recipe.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	List<User> findAllUser() {
		return (List<User>) repo.findAll();
	}

	Optional<User> getUserById(Integer user_id) {
		return repo.findById(user_id);
	}
//	public void updateUser(Integer id, User userdetails) {
//		repo.save(userdetails);
//	}

	public Optional<User> updateUser(Integer id, User user) {
		if (repo.existsById(id)) {
			user.setUserId(id);
			return Optional.of(repo.save(user));
		}
		return Optional.empty();
	}

	public Integer addUser(User userdetails) {
		return repo.save(userdetails).userId;
	}

	public User findByUsername(String userName) {
		return repo.findByUserName(userName);
	}

}
