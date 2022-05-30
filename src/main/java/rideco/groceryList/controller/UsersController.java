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
import rideco.groceryList.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
	  return usersService.getAllUsers();
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User newUser) {
	  return usersService.createUser(newUser);
	}
	
	@GetMapping("users/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
	    
	  return usersService.getUserById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User newUser, @PathVariable Integer id) {
	    
	  return usersService.updateUser(newUser,id);
	}
	
	@DeleteMapping("users/{id}")
	public 
	void deleteUser(@PathVariable Integer id) {
		usersService.deleteUser(id);
	}
	
	

}
