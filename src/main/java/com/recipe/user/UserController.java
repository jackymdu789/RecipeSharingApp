package com.recipe.user;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
//@RequestMapping("/api/")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/user")
	List<User> getAllusers() {
		return service.findAllUser();
	}

	@GetMapping("/user/{user_id}")
	Optional<User> getuserById(@PathVariable Integer user_id) {
		return service.getUserById(user_id);
	}

	@PostMapping("/user")
	void addUser(@RequestBody User userdetails) {
		service.addUser(userdetails);
	}

	@PutMapping("/user/{id}")
	public void updateUser(@PathVariable Integer id, @RequestBody User userdetails) {
		service.updateUser(userdetails);
	}

	
}
