package rideco.groceryList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rideco.groceryList.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
