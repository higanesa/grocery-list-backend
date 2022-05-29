package rideco.groceryList.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
    private Integer userId;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "age")
    private int age;   
	
	public User(){
		   super();
		}
	

	public User(Integer userId, String name, int age, List<GroceryList> items) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;		
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + "]";
	}
	
	
    
    

	
	

    
    
    
    

}
