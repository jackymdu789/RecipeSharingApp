package com.recipe.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipes.Recipe;
import com.recipe.recipes.RecipeService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
//@RequestMapping("/api/")
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private RecipeService rservice;

	@GetMapping("/alluser")
	List<User> getAllusers() {
		return service.findAllUser();
	}

	@GetMapping("/user/{user_id}")
	Optional<User> getuserById(@PathVariable Integer user_id) {
		return service.getUserById(user_id);
	}

	@PostMapping("/user")
	Integer addUser(@RequestBody User userdetails) {
		return service.addUser(userdetails);
	}

	@PutMapping("user/{id}/addRecipe")
	public ResponseEntity<User> addRecipeToUser(@PathVariable Integer id, @RequestBody Recipe recipe) {
		Optional<User> user = service.getUserById(id);
		if (user.isPresent()) {
			User existingUser = user.get();
			recipe.setUser(existingUser); // Set the user for the recipe
			rservice.addRecipe(recipe); // Save the recipe
			existingUser.getRecipes().add(recipe); // Add recipe to user
			service.updateUser(id, existingUser); // Update the user
			return ResponseEntity.ok(existingUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		// service.updateUser(userdetails);
		Optional<User> updatedUser = Optional.empty();
		return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
