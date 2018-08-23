package shopping;

import java.io.Serializable;

public class Cart implements Serializable{
		private static final long serialVersionUID = 1L;
	   private String username;
	   private String qty;
	   private String item_name;
		
	   public String getName() {
	      return item_name;
		}

	   public void setName(String item_name) {
	      this.item_name = item_name;
		}
				
	   public String getQty() {
	      return qty;
		}

	   public void setQty(String qty) {
	      this.qty = qty;
		}
		
				
	   public String getUserName() {
	      return username;
				}

	   public void setUserName(String username) {
	      this.username = username;
				}

	}
