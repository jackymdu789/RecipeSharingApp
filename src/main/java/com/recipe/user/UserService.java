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
	Optional <User> getUserById(Integer user_id) {
		return repo.findById(user_id);
	}
	public void updateUser(User userdetails) {
		repo.save(userdetails);
	}
	public void addUser(User userdetails) {
		repo.save(userdetails);
	}
	
	
}
