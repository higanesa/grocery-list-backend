package rideco.groceryList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grocery_list")
public class GroceryList {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemId")
    private Integer itemId;
	
	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "itemQuantity")
	private Integer itemQuantity;
	
	@Column(name = "isPurchased")
	private boolean isPurchased;
	
	@Column(name = "userId")
	private Integer userId;	
	
	public GroceryList(){
		   super();
		}


	public GroceryList(Integer itemId, String itemName, Integer itemQuantity, boolean isPurchased, Integer userId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.isPurchased = isPurchased;
		this.userId = userId;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Integer getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public boolean isPurchased() {
		return isPurchased;
	}


	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "GroceryList [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity
				+ ", isPurchased=" + isPurchased + ", userId=" + userId + "]";
	}
	
	
	
	

	
	
	
	
	
	

}
