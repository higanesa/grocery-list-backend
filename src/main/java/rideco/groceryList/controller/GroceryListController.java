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
	
	@GetMapping("/groceryList")
	public List<GroceryList> getAllGroceryList() {
	  return groceryListService.getAllGroceryList();
	}
	
	@PostMapping("/groceryList")
	public GroceryList createGroceryList(@RequestBody GroceryList newUser) {
	  return groceryListService.createGroceryList(newUser);
	}
	
	@GetMapping("groceryList/{id}")
	public Optional<GroceryList> getGroceryListById(@PathVariable Integer id) {
	    
	  return groceryListService.getGroceryListById(id);
	}
	
	@PutMapping("/groceryList/{id}")
	public GroceryList updateGroceryList(@RequestBody GroceryList newGroceryList, @PathVariable Integer id) {
	    
	  return groceryListService.updateGroceryList(newGroceryList,id);
	}
	
	@DeleteMapping("groceryList/{id}")
	public void deleteGroceryList(@PathVariable Integer id) {
		groceryListService.deleteGroceryList(id);
	}

}
