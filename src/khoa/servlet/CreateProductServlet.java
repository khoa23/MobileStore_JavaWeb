package khoa.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import khoa.models.Product;
import khoa.utils.DBUtils;
import khoa.utils.MyUtils;

@WebServlet(urlPatterns = { "/createProduct" })
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateProductServlet() {
		super();
	}

	// Show product creation page.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(req);
		
		String name = req.getParameter("name"); 
		float price = Float.parseFloat(req.getParameter("price"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String description = req.getParameter("description");
		String manufacturer = req.getParameter("manufacturer");
		int category = Integer.parseInt(req.getParameter("category"));
		String condition = req.getParameter("condition");
		
		String fileName = "";
		String uploadPath = getServletContext().getInitParameter("upload.location");
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		Part part = req.getPart("image");
		fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		System.out.println(fileName);
		InputStream input = part.getInputStream();
		Files.copy(input, Paths.get(uploadPath + File.separator + fileName));
		
		Product p = new Product(name, price, quantity, description, manufacturer, category, condition, fileName);
	      
		try {
				DBUtils.insertProduct(conn, p);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath() + "/productList");
	}

}
