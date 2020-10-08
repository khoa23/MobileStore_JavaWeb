<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="vn">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<title>Product List</title>
	<style>
		.grid-container {
			margin-top: 30px;
		  	display: grid;
		  	grid-template-columns: 23.5% 23.5% 23.5% 23.5%;
		  	grid-column-gap: 2%;
		  	clear:both;
		  	float:left;
		}
		.grid-item {
		  	border-style: groove;
		  	border-radius: 3px;
		  	padding:10px;
		  	text-align: left;
		}
		.grid-item img{
			width: 100%;
		}

	</style>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="store-name" style="background: #E0E0E0; padding: 0px; padding: 2%" >
		<button type="button" class="btn btn-default btn-sm"  style="float: right">
			<a href="${pageContext.request.contextPath}/cart ">
          			<span class="glyphicon glyphicon-shopping-cart"></span> View cart
        	</a>

        </button>
		<p style="font-size: 400%">Products</p>
		<p>All the available products in our store</p>
	</div>
	<div class="section">
    	<div class="container">
	  		<div class="grid-container">
	      		<c:forEach items="${productList}" var="product">
	      			<div class="grid-item">
	      				<h3>${product.name}</h3>
	      				<img src='images/${product.image}'/><!-- ảnh trong thư mục ROOT -->
	      				<p>${product.description}</p>
	      				<div>${product.price} USD</div><br>
	      				<div>${product.quantity} in stock</div><br>
	      				<a href="${pageContext.request.contextPath }/productDetails?id=${product.id}" class="btn btn-primary">
          					<span class="glyphicon glyphicon-info-sign"></span> Details
        				</a>
        				<a href="${pageContext.request.contextPath }/cart?action=add&id=${product.id}" class="btn btn-warning">
          					<span class="glyphicon glyphicon-shopping-cart"></span> Order Now
        				</a>	
	      			</div>
				</c:forEach>
			</div>
        </div>
	</div>
</body>
</html>