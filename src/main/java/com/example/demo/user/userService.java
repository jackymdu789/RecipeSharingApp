package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
	@Autowired
	private userRepository repo;

	List<userDetails> findAllUser() {
		return (List<userDetails>) repo.findAll();
	}
	Optional <userDetails> getUserById(Integer user_id) {
		return repo.findById(user_id);
	}
	public void updateUser(userDetails userdetails) {
		repo.save(userdetails);
	}
	public void addUser(userDetails userdetails) {
		repo.save(userdetails);
	}
	public void deleteUser(Integer id) {
		repo.deleteById(id);
	}

}
