package pack.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.connection.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class ViewPackageController
 */
public class ViewPackageController extends HttpServlet {
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
    public ViewPackageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id"); 

        if (id != null) { 
            try {
                packageId = Integer.parseInt(id); 

                //call getConnection() method 
                con = ConnectionManager.getConnection();

                //3. create statement
                ps = con.prepareStatement("SELECT * FROM packages WHERE packageId=?");
                ps.setInt(1, packageId);

                //4. execute query
                rs = ps.executeQuery();

                if(rs.next()) {
                    packageId = rs.getInt("packageId");
                    packageName = rs.getString("packageName"); 
                    packagePrice = rs.getDouble("packagePrice"); 
                }

                //5. close connection 
                con.close(); 

            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid package ID format."); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: No package ID provided."); 
        }

        request.setAttribute("packageId", packageId);
        request.setAttribute("packageName", packageName); 
        request.setAttribute("packagePrice", packagePrice); 

        RequestDispatcher req = request.getRequestDispatcher("indexPackage.jsp"); 
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
