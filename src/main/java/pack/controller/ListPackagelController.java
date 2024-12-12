package pack.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.connection.ConnectionManager;
import pack.model.Package;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ListPackagelController
 */
public class ListPackagelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	int packageId;
	String packageName;
	double packagePrice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPackagelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Package> packages = new ArrayList<Package>();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			stmt = con.createStatement();
			String sql = "SELECT * FROM packages ORDER BY packageid";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
                Package p = new Package(
                    rs.getInt("packageId"), 
                    rs.getString("packageName"), 
                    rs.getDouble("packagePrice")
                );
                packages.add(p);
            }

			request.setAttribute("packages", packages); // Make the list available to the JSP

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		//set attribute to a servlet request. Set the attribute name to packages
		request.setAttribute("packages", packages);

		//Obtain the RequestDispatcher from the request object. The the pathname to the resource is listShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("listPackage.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response); 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
