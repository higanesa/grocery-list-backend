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

import rideco.groceryList.entity.GroceryList;
import rideco.groceryList.repository.GroceryListRepository;

@RestController
public class GroceryListController {
	
	@Autowired
	private GroceryListRepository groceryListRepository;
	
	@GetMapping("/groceryList")
	List<GroceryList> getAllGroceryList() {
	  return groceryListRepository.findAll();
	}
	
	@PostMapping("/groceryList")
	GroceryList createGroceryList(@RequestBody GroceryList newUser) {
	  return groceryListRepository.save(newUser);
	}
	
	@GetMapping("groceryList/{id}")
	Optional<GroceryList> getGroceryListById(@PathVariable Integer id) {
	    
	  return groceryListRepository.findById(id);
	}
	
	@PutMapping("/groceryList/{id}")
	GroceryList updateGroceryList(@RequestBody GroceryList newGroceryList, @PathVariable Integer id) {
	    
	  return groceryListRepository.findById(id)
	    .map(groceryList -> {
	    	groceryList.setItemName(newGroceryList.getItemName());
	    	groceryList.setItemQuantity(newGroceryList.getItemQuantity());
	    	groceryList.setPurchased(newGroceryList.isPurchased());
	    	groceryList.setUserId(newGroceryList.getUserId());
	      return groceryListRepository.save(groceryList);
	    })
	    .orElseGet(() -> {
	    	newGroceryList.setUserId(id);
	      return groceryListRepository.save(newGroceryList);
	    });
	}
	
	@DeleteMapping("groceryList/{id}")
	void deleteGroceryList(@PathVariable Integer id) {
		groceryListRepository.deleteById(id);
	}

}
