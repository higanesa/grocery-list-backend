package rideco.groceryList.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import rideco.groceryList.controller.GroceryListController;
import rideco.groceryList.entity.GroceryList;
import rideco.groceryList.service.GroceryListService;

@SpringBootTest
public class GroceryListControllerTest {
	
	@InjectMocks
	private GroceryListController groceryListController;
	
    @Mock
    private GroceryListService groceryListService;
    
    @Test
    void getAllGroceryListTest() {
    	List<GroceryList> groceryList = new ArrayList<GroceryList>();
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	groceryList.add(grocery);
    	when(groceryListService.getAllGroceryList()).thenReturn(groceryList);
    	
    	List<GroceryList> result = groceryListController.getAllGroceryList();
    	assertEquals(result,groceryList);
    }
    
    @Test
    void createGroceryListTest() {
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	when(groceryListService.createGroceryList(grocery)).thenReturn(grocery);
    	
    	GroceryList result = groceryListController.createGroceryList(grocery);
    	assertEquals(result,grocery);
    	
    }
    
    @Test
    void getGroceryListByIdTest() {
    	
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	when(groceryListService.getGroceryListById(1)).thenReturn(Optional.of(grocery));
    	
    	Optional<GroceryList> result = groceryListController.getGroceryListById(1);
    	assertEquals(result,Optional.of(grocery));
    	
    }
    
    @Test
    void updateGroceryListTest() {
    	GroceryList grocery = new GroceryList(1,"milk",1,false,1);
    	when(groceryListService.updateGroceryList(grocery,1)).thenReturn(grocery);
    	
    	GroceryList result = groceryListController.updateGroceryList(grocery,1);
    	assertEquals(result,grocery);
    }

}
