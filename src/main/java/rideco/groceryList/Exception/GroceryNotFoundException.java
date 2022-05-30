package rideco.groceryList.Exception;

public class GroceryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	GroceryNotFoundException(Integer id) {
		  super("Could not find grocery item " + id);
		}

}
