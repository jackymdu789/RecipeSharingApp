package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
//@RequestMapping("/api/")
public class userController {
	@Autowired
	private userService service;

	@GetMapping("/user")
	List<userDetails> getAllusers() {
		return service.findAllUser();
	}

	@GetMapping("/user/{user_id}")
	Optional<userDetails> getuserById(@PathVariable Integer user_id) {
		return service.getUserById(user_id);
	}

	@PostMapping("/user")
	void addUser(@RequestBody userDetails userdetails) {
		service.addUser(userdetails);
	}

	@PutMapping("/user/{id}")
	public void updateUser(@PathVariable Integer id, @RequestBody userDetails userdetails) {
		service.updateUser(userdetails);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(Integer id) {
		service.deleteUser(id);
	}
}
