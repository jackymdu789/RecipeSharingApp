package com.recipe.dietary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DietaryController {
	@Autowired
	DietaryService service;

	@GetMapping("/dietary")
	List<Dietary> getAllDietary() {
		return (List<Dietary>) service.getAllDietary();
	}

	@GetMapping("/dietary/{id}")
	Optional<Dietary> getDietaryById(@PathVariable Integer id) {
		return service.getDietaryById(id);
	}

	@PostMapping("/dietary")
	void addDietary(@RequestBody Dietary diet) {
		service.addDietary(diet);
	}
}
