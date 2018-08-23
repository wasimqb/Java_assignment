package shopping;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
   private String username;
   private String password;
   private String name;
   public boolean valid;
	
   public String getName() {
      return this.name;
	}

   public void setName(String name) {
      this.name = name;
	}
			
   public String getPassword() {
      return password;
	}

   public void setPassword(String password) {
      this.password = password;
	}
	
			
   public String getUserName() {
      return username;
			}

   public void setUserName(String username) {
      this.username = username;
			}

}