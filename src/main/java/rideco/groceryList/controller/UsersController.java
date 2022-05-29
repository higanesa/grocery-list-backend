package rideco.groceryList.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rideco.groceryList.entity.User;
import rideco.groceryList.repository.UserRepository;

@RestController
public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	List<User> getAllUsers() {
	  return userRepository.findAll();
	}
	
	@PostMapping("/users")
	User createUser(@RequestBody User newUser) {
	  return userRepository.save(newUser);
	}
	
	@GetMapping("users/{id}")
	Optional<User> getUserById(@PathVariable Integer id) {
	    
	  return userRepository.findById(id);
	}
	
	@PutMapping("/users/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Integer id) {
	    
	  return userRepository.findById(id)
	    .map(user -> {
	      user.setName(newUser.getName());
	      user.setAge(newUser.getAge());
	      return userRepository.save(user);
	    })
	    .orElseGet(() -> {
	    	newUser.setUserId(id);
	      return userRepository.save(newUser);
	    });
	}
	
	@DeleteMapping("users/{id}")
	void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
	

}
