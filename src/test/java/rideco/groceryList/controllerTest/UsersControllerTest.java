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

import rideco.groceryList.controller.UsersController;
import rideco.groceryList.entity.User;
import rideco.groceryList.service.UsersService;

@SpringBootTest
public class UsersControllerTest {
	
	@InjectMocks
	private UsersController usersController;
	
    @Mock
    private UsersService usersService;
    
    @Test
    void getAllUsersTest() {
    	List<User> userList = new ArrayList<User>();    	
    	User user1 = new User(1,"Harish",26);
    	userList.add(user1);
    	
    	when(usersService.getAllUsers()).thenReturn(userList);
    	
    	List<User> result = usersController.getAllUsers();    	 
    	assertEquals(result,userList);
    	
    	
    }
    
    @Test
    void getUserByIdTest() {
    	User user1 = new User(1,"Harish",26);
    	when(usersService.getUserById(1)).thenReturn(Optional.of(user1));
    	
    	Optional<User> result = usersController.getUserById(1);    	
    	assertEquals(result,Optional.of(user1));
    }
    
    @Test
    void createUserTest() {
    	User user1 = new User(1,"Harish",26);
    	when(usersService.createUser(user1)).thenReturn(user1);
    	
    	User result = usersController.createUser(user1);    	
    	assertEquals(result,user1);
    	
    	
    }
    
    @Test
    void updateUserTest() {
    	User user1 = new User(1,"Harish",26);
    	when(usersService.updateUser(user1, 1)).thenReturn(user1);
    	
       	User result = usersController.updateUser(user1,1);    	
    	assertEquals(result,user1);
    	
    }   

    

	



}
