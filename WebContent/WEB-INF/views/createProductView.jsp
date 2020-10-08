<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Add Product</title>
</head>
<body>

	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="store-name" style="background: #E0E0E0; padding: 2%" >
		<button type="button" class="btn btn-danger" style="float: right">logout</button>
		<p style="font-size: 400%">Products</p>
		<p>Add products</p>
	</div>
	
	<div style="padding-left: 5%">
		<h3>Add new product</h3><hr>

		<p style="color: red;">${errorString}</p>
		
		<div style="padding-left: 5%; padding-bottom: 1%">
			<form method="POST"
			action="${pageContext.request.contextPath}/createProduct">
			<table border="0">
				<tr>
					<td>Product Name</td>
					<td><input type="text" class="form-control" name="name" value="${product.name}" /></td>
				</tr>
				<tr>
					<td>Unit Price</td>
					<td><input type="text" class="form-control" name="price" value="${product.price}" /></td>
				</tr>
				<tr>
					<td>Units In Stock</td>
					<td><input type="number" class="form-control" name="quantity" value="${product.quantity}" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea type="text" class="form-control" name="description" value="${product.description}" ></textarea></td>
				</tr>
				<tr>
					<td>Manufacturer</td>
					<td><input type="text" class="form-control" name="manufacturer" value="${product.manufacturer}" /></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" class="form-control" name="price" value="${product.price}" /></td>
				</tr>
				<tr>
					<td>Condition</td>
					<td>
						<fieldset id="group2">
							<input type="radio" value="New" name="condition"> New
						    <input type="radio" value="Old" name="condition"> Old
						    <input type="radio" value="Refurbished" name="condition"> Refurbished
						</fieldset>
					</td>
					
				</tr>
				
				<!--hinh anh-->
				<tr>
					<td>Product Image File</td>
					<td>
	            		<div class="lblinput">
	               			 <input type="file" id="txtpic" name="txtpic" accept=".PNG,.GIF,.JPG" />
	            		</div>
					</td>
				</tr>
				<tr>
					<td colspan="4"><input type="submit" class="btn btn-primary" value="Add Product" /> </td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>