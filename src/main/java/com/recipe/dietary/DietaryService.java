package com.recipe.dietary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietaryService {
	@Autowired
	DietaryRepository repo;

	List<Dietary> getAllDietary() {
		return (List<Dietary>) repo.findAll();
	}

	public Optional<Dietary> getDietaryById(Integer id) {
		return repo.findById(id);
	}

	void addDietary(Dietary diet) {
		repo.save(diet);
	}
}
