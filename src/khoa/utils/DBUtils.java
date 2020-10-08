package khoa.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import khoa.models.Product;
import khoa.models.UserAccount;


public class DBUtils {
	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.User_Name, a.Password from User_Account a " //
				+ " where a.User_Name = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			//String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			//user.setGender(gender);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.User_Name, a.Password from User_Account a where a.User_Name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			//String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			//user.setGender(gender);
			return user;
		}
		return null;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "select p.ProductID, ProductName, Price, Quantity, Description, Manufacturer, Condition, Picture, c.CategoryName, c.CateID from PRODUCT p, CATEGORY c where p.CateID = c.CateID";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			int id = rs.getInt("ProductID");
			String name = rs.getString("ProductName");
			float price = rs.getFloat("Price");
			int quantity = rs.getInt("Quantity");
			String description = rs.getString("Description");
			String manufacturer = rs.getString("Manufacturer");
			String condition = rs.getString("Condition");
			String picture = rs.getString("Picture");
			String category = rs.getString("CategoryName");
			int cateid = rs.getInt("CateID");
			
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setDescription(description);
			product.setManufacturer(manufacturer);
			product.setCondition(condition);
			product.setImage(picture);
			product.setCateID(cateid);
			product.setCategory(category);
			
			list.add(product);
		}
		return list;
	}

	public static Product findProduct(Connection conn, String id) throws SQLException {
		String sql = "Select ProductID, ProductName, Price, Quantity, Description, Manufacturer, CateID, Condition, Picture from Product  where ProductID=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			
			String name = rs.getString("ProductName");
			float price = rs.getFloat("Price");
			int quantity = (int) rs.getInt("Quantity");
			String description = (String) rs.getString("Description");
			String manufacturer = (String) rs.getString("Manufacturer");
			int cateid = (int) rs.getInt("CateID");
			String condition = (String) rs.getString("Condition");
			String image = (String) rs.getString("Picture");
			Product product = new Product(name, price, quantity, description, manufacturer, cateid, condition, image);
			return product;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setDouble(2, product.getPrice());
		pstm.setInt(3, product.getId());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product (ProductName,Price, Quantity, Description,Manufacturer, CateID,Condition, Picture)  values (?,?,?,?,?,?,?,?)";

		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setDouble(2, product.getPrice());
		pstm.setInt(3, product.getQuantity());
		pstm.setString(4, product.getDescription());
		pstm.setString(5, product.getManufacturer());
		pstm.setInt(6, product.getCateID());
		pstm.setString(7, product.getCondition());
		pstm.setString(8, product.getImage());
	
		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

}
