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
 * Servlet implementation class DeletePackageController
 */
public class DeletePackageController extends HttpServlet {
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
    public DeletePackageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id"); // Get the 'id' parameter

        if (id != null) {
            try {
                packageId = Integer.parseInt(id);

                // call getConnection() method 
                con = ConnectionManager.getConnection();

                // 3. create statement 
                String sql = "DELETE FROM packages WHERE packageId = ?"; // Use packageId
                ps = con.prepareStatement(sql);

                ps.setInt(1, packageId);

                // 4. execute query
                ps.executeUpdate();

                // 5. close connection 
                con.close();

            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid package ID format.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: No package ID provided.");
        }

        // Obtain the RequestDispatcher from the request object. The pathname to the resource is index.html
        RequestDispatcher req = request.getRequestDispatcher("listPackage.jsp");

        // Dispatch the request to another resource using forward() methods of the RequestDispatcher 
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
