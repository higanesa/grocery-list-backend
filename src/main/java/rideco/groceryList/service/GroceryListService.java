package rideco.groceryList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rideco.groceryList.entity.GroceryList;
import rideco.groceryList.repository.GroceryListRepository;

@Service
public class GroceryListService {
	
	@Autowired
	private GroceryListRepository groceryListRepository;
	
	// Service method to get all grocery list items
	public List<GroceryList> getAllGroceryList() {
	  return groceryListRepository.findAll();
	}
	
	// Service method to create new grocery list item
	public GroceryList createGroceryList(GroceryList newUser) {
	  return groceryListRepository.save(newUser);
	}
	
	// Service method to get grocery list item by ID
	public Optional<GroceryList> getGroceryListById(Integer id) {
	    
	  return groceryListRepository.findById(id);
	}
	
	// Service method to update/edit grocery list item
	public GroceryList updateGroceryList(GroceryList newGroceryList, Integer id) {
	    
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
	
	// Delete method to delete grocery list item
	public void deleteGroceryList(Integer id) {
		groceryListRepository.deleteById(id);
	}

	public Optional<GroceryList> updateGroceryListPurchased(Integer id) {
		  return groceryListRepository.findById(id)
				    .map(groceryList -> {				    	
				    	groceryList.setPurchased(true);				    	
				      return groceryListRepository.save(groceryList);
				    });
	}

}
