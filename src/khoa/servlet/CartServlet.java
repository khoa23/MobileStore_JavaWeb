package khoa.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import khoa.models.Item;
import khoa.models.Product;
import khoa.utils.DBUtils;
import khoa.utils.MyUtils;

@WebServlet(urlPatterns = { "/cart" })
public class CartServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if (action != null)
			doPost(req, resp);
		else{
			RequestDispatcher dispatcher = req.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/cartView.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Connection conn = MyUtils.getStoredConnection(req);
		String productIdStr = req.getParameter("id");
		String action = req.getParameter("action");
		List<Item> cart = null;
		
		if(action.equalsIgnoreCase("add")){
			int productId = Integer.parseInt(productIdStr);
			if(session.getAttribute("cart") == null){
				try {
					Product p = DBUtils.findProduct(conn, productIdStr);
				
					cart = new ArrayList<Item>();
					cart.add(new Item(p, 1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					cart = (List<Item>) session.getAttribute("cart");
					
					Product p = DBUtils.findProduct(conn, productIdStr);
					
					int index = isExisting(productId, cart);
					if(index == -1)
						cart.add(new Item(p, 1));
					else{
						int quantity_new = cart.get(index).getQuantity() + 1;
						cart.get(index).setQuantity(quantity_new);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(action.equalsIgnoreCase("remove")){
			int productId = Integer.parseInt(productIdStr);
			cart = (List<Item>) session.getAttribute("cart");
			
			int index = isExisting(productId, cart);
			int quantity = cart.get(index).getQuantity();
			
			if(quantity > 1){
				int quantity_new = cart.get(index).getQuantity() - 1;
				cart.get(index).setQuantity(quantity_new);
			}else{
				cart.remove(index);
			}
		}
		else{
			cart = (List<Item>) session.getAttribute("cart");
			cart.clear();
		}
		
		
		
		session.setAttribute("cart", cart);
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
	
	private int isExisting(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
