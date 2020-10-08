package khoa.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khoa.models.Product;
import khoa.utils.MyUtils;

@WebServlet(urlPatterns = { "/productDetails" })
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetailsServlet() {
		super();
	}

	// Show product edit page.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(req);
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		Product p = null;
		
		String errorString = null;
		
//		try {
//			p = DBUtils.findProduct(conn, idStr);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			errorString = e.getMessage();
//		}
		
		try {
			String sql = "Select ProductID, ProductName, Price, Quantity, Description, Manufacturer, CateID, Picture from Product  where ProductID = ?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("ProductID");
				String name = rs.getString("ProductName");
				float price = rs.getFloat("Price");
				int quantity = rs.getInt("Quantity");
				String description = rs.getString("Description");
				String image = rs.getString("Picture");
				int cateid = rs.getInt("CateID");
				String manufacturer = rs.getString("Manufacturer");
				p = new Product();
				p.setId(code);
				p.setName(name);
				p.setPrice(price);
				p.setDescription(description);
				p.setQuantity(quantity);
				p.setImage(image);
				p.setManufacturer(manufacturer);
				p.setCateID(cateid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("errorString", errorString);
		req.setAttribute("product", p);
		
		// Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = req.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/productDetailsView.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}