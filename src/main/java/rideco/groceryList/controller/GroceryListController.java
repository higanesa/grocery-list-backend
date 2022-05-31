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
import rideco.groceryList.service.GroceryListService;

@RestController
public class GroceryListController {
	
	@Autowired
	private GroceryListService groceryListService;
	
	// Controller method to get all grocery list items
	@GetMapping("/groceryList")
	public List<GroceryList> getAllGroceryList() {
	  return groceryListService.getAllGroceryList();
	}
	
	// Controller method to create new grocery list item
	@PostMapping("/groceryList")
	public GroceryList createGroceryList(@RequestBody GroceryList newUser) {
	  return groceryListService.createGroceryList(newUser);
	}
	
	// Controller method to get grocery list item by ID
	@GetMapping("groceryList/{id}")
	public Optional<GroceryList> getGroceryListById(@PathVariable Integer id) {
	    
	  return groceryListService.getGroceryListById(id);
	}
	
	// Controller method to update/edit grocery list item
	@PutMapping("/groceryList/{id}")
	public GroceryList updateGroceryList(@RequestBody GroceryList newGroceryList, @PathVariable Integer id) {
	    
	  return groceryListService.updateGroceryList(newGroceryList,id);
	}
	
	// Controller method to delete grocery list item
	@DeleteMapping("groceryList/{id}")
	public void deleteGroceryList(@PathVariable Integer id) {
		groceryListService.deleteGroceryList(id);
	}
	
	@GetMapping("/groceryList/purchased/{id}")
	public Optional<GroceryList> updateGroceryListPurchased(@PathVariable Integer id) {	    
	  return groceryListService.updateGroceryListPurchased(id);
	}

}
