package rideco.groceryList.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import rideco.groceryList.entity.GroceryList;
import rideco.groceryList.repository.GroceryListRepository;
import rideco.groceryList.service.GroceryListService;

@SpringBootTest
public class GroceryListControllerTest {
	

	@InjectMocks
    private GroceryListService groceryListService;
	
	@Mock
	private GroceryListRepository groceryListRepository;
    
    @Test
    void getAllGroceryListTest() {
    	List<GroceryList> groceryList = new ArrayList<GroceryList>();
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	groceryList.add(grocery);
    	when(groceryListRepository.findAll()).thenReturn(groceryList);
    	
    	List<GroceryList> result = groceryListService.getAllGroceryList();
    	assertEquals(result,groceryList);
    }
    
    @Test
    void createGroceryListTest() {
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	when(groceryListRepository.save(grocery)).thenReturn(grocery);
    	
    	GroceryList result = groceryListService.createGroceryList(grocery);
    	assertEquals(result,grocery);
    	
    }
    
    @Test
    void getGroceryListByIdTest() {
    	
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	when(groceryListRepository.findById(1)).thenReturn(Optional.of(grocery));
    	
    	Optional<GroceryList> result = groceryListService.getGroceryListById(1);
    	assertEquals(result,Optional.of(grocery));
    	
    }
    
    @Test
    void updateGroceryListTest() {
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	when(groceryListRepository.save(grocery)).thenReturn(grocery);
    	when(groceryListRepository.findById(1)).thenReturn(Optional.of(grocery));
    	
    	GroceryList result = groceryListService.updateGroceryList(grocery,1);
    	assertEquals(result,grocery);
    }

}
