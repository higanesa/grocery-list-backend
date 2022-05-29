package rideco.groceryList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rideco.groceryList.entity.GroceryList;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {

}
