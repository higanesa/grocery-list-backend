package rideco.groceryList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import rideco.groceryList.entity.GroceryList;
import rideco.groceryList.repository.GroceryListRepository;

@Service
public class GroceryListService {
	
	@Autowired
	private GroceryListRepository groceryListRepository;
	
	public List<GroceryList> getAllGroceryList() {
	  return groceryListRepository.findAll();
	}
	
	public GroceryList createGroceryList(@RequestBody GroceryList newUser) {
	  return groceryListRepository.save(newUser);
	}
	
	public Optional<GroceryList> getGroceryListById(@PathVariable Integer id) {
	    
	  return groceryListRepository.findById(id);
	}
	
	public GroceryList updateGroceryList(@RequestBody GroceryList newGroceryList, @PathVariable Integer id) {
	    
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
	
	public void deleteGroceryList(@PathVariable Integer id) {
		groceryListRepository.deleteById(id);
	}

}
