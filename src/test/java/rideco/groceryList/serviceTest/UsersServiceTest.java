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

import rideco.groceryList.entity.User;
import rideco.groceryList.repository.UserRepository;
import rideco.groceryList.service.UsersService;

@SpringBootTest
public class UsersServiceTest {
	
	@InjectMocks
	private UsersService usersService;
	
    @Mock
    private UserRepository usersRepository;
    
    @Test
    void getAllUsersTest() {
    	List<User> userList = new ArrayList<User>();    	
    	User user1 = new User(1,"Harish",26);
    	userList.add(user1);
    	
    	when(usersRepository.findAll()).thenReturn(userList);
    	
    	List<User> result = usersService.getAllUsers();    	 
    	assertEquals(result,userList);
    	
    	
    }
    
    @Test
    void getUserByIdTest() {
    	User user1 = new User(1,"Harish",26);
    	when(usersRepository.findById(1)).thenReturn(Optional.of(user1));
    	
    	Optional<User> result = usersService.getUserById(1);    	
    	assertEquals(result,Optional.of(user1));
    }
    
    @Test
    void createUserTest() {
    	User user1 = new User(1,"Harish",26);
    	when(usersRepository.save(user1)).thenReturn(user1);
    	
    	User result = usersService.createUser(user1);    	
    	assertEquals(result,user1);
    	
    	
    }
    
    @Test
    void updateUserTest() {
    	User user1 = new User(1,"Harish",26);
    	when(usersRepository.findById(1)).thenReturn(Optional.of(user1));
    	when(usersRepository.save(user1)).thenReturn(user1);
    	
       	User result = usersService.updateUser(user1,1);    	
    	assertEquals(result,user1);
    	
    }   

    

	



}
