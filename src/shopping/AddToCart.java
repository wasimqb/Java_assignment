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
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletInputStream body;  
    Cart user;
    ObjectMapper mapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String input_uname;
		String input_item_name;
		String input_qty;
		try{
			body = request.getInputStream();
			user = mapper.readValue(body, Cart.class);
			
			input_uname =  user.getUserName();
			input_qty = user.getQty();
			input_item_name = user.getName();
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/shopping","root","wasim121");  
			
			Statement stmt = con.createStatement();  
			stmt.execute("INSERT INTO cart VALUES('"+input_item_name+"','"+input_qty+"','"+input_uname+"')");  
			con.close();	
			}catch(Exception e){ System.out.println(e);}  

	}

}
