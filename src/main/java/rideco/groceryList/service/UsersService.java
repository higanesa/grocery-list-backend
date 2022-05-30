package rideco.groceryList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import rideco.groceryList.entity.User;
import rideco.groceryList.repository.UserRepository;

@Service
public class UsersService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		  return userRepository.findAll();
		}
	
	public User createUser(@RequestBody User newUser) {
	  return userRepository.save(newUser);
	}
	
	public Optional<User> getUserById(@PathVariable Integer id) {
	    
	  return userRepository.findById(id);
	}
	
	public User updateUser(@RequestBody User newUser, @PathVariable Integer id) {
	    
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
	
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}

}
