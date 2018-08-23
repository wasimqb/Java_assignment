package shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletInputStream body;  
    User user;
    ObjectMapper mapper = new ObjectMapper();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String input_uname;
		String input_password;
		String name = null;
		String pass = null;
		
		try{
			body = request.getInputStream();
			user = mapper.readValue(body, User.class);
			
			input_uname =  user.getUserName();
			input_password = user.getPassword();
						
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/shopping","root","wasim121");  
			
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT password, name from user_info where uname = '"+input_uname+"'"); 
			if(rs.next())
				{
				name = rs.getString("name");
				pass = rs.getString("password");
				}
			
			if(input_password.equals(pass))
				response.getWriter().append("Welcome ").append(name);
			con.close();	
			}catch(Exception e){ System.out.println(e);}  
	}

}