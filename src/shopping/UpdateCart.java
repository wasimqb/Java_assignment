package shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletInputStream body;  
    Cart cart;
    ObjectMapper mapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String input_uname;
		String input_qty;
		String input_item_name;
		try{
			body = request.getInputStream();
			cart = mapper.readValue(body, Cart.class);
			
			input_uname =  cart.getUserName();
			input_item_name = cart.getName();
			input_qty = cart.getQty();
		
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/shopping","root","wasim121");  
			
			Statement stmt = con.createStatement();  
			stmt.execute("UPDATE cart SET quantity='"+input_qty+"' WHERE username='"+input_uname+"' and item_name='"+input_item_name+"'");  
			con.close();	
			}
		catch(Exception e)
			{ 
				System.out.println(e);
			}  

	}

}
