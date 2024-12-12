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
import pack.model.Package;

/**
 * Servlet implementation class UpdatePackageController
 */
public class UpdatePackageController extends HttpServlet {
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
    public UpdatePackageController() {
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

                if (rs.next()) {
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

        // Set attributes with the correct variable name ('pkg')
        request.setAttribute("pkg", new Package(packageId, packageName, packagePrice)); 

        RequestDispatcher req = request.getRequestDispatcher("updatePackage.jsp");
        req.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id"); 

        if (id != null) {
            try {
                packageId = Integer.parseInt(id);
                packageName = request.getParameter("packageName");
                packagePrice = Double.parseDouble(request.getParameter("packagePrice"));

                //call getConnection() method 
                con = ConnectionManager.getConnection();

                //3. create statement
                ps = con.prepareStatement("UPDATE packages SET packageName=?, packagePrice=? WHERE packageId=?"); 
                ps.setString(1, packageName);
                ps.setDouble(2, packagePrice);
                ps.setInt(3, packageId);

                //4. execute query
                ps.executeUpdate();

                //5. close connection 
                con.close();

            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid package ID or price format.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: No package ID provided.");
        }

        RequestDispatcher req = request.getRequestDispatcher("listPackage.jsp"); 
        req.forward(request, response); 
    }
	
}
