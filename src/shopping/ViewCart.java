package shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String input_uname;
		String start;
		String end;
		String item_name;
		String qty;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			start = request.getParameter("start");
			end = request.getParameter("end");
			input_uname = request.getParameter("username");
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/shopping","root","wasim121");  
			
			Statement stmt = con.createStatement();
			String sql = "select * from cart where username = '"+input_uname+"' limit "+start+","+end+"";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				item_name = rs.getString("item_name");
				qty = rs.getString("quantity");
				
				map.put(item_name,qty);
			}
			
		}catch(Exception ex){
			System.out.println(ex);
        }
		
		for (Map.Entry<String, String> i: map.entrySet())
		{
			response.getWriter().append("Product : ").append(i.getKey()+"\t");
			response.getWriter().append("Quantity : ").append(i.getValue()+"\n");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
