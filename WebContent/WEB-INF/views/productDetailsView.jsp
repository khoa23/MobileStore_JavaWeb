<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="vn">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<title>Product Details</title>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="store-name" style="background: #E0E0E0; padding: 0px; padding: 2%" >
		<p style="font-size: 400%">Products</p>
	</div>
	<!--Main layout-->
  	<main class="mt-5 pt-4" style="padding-top: 2%">
	    <div class="container dark-grey-text mt-5">
	
	      <!--Grid row-->
	      <div class="row wow fadeIn">
	
	        <!--Grid column-->
	        <div class="col-md-6 mb-4">
	
	          <img width="390" height="450" src="images/${product.image}" /><!-- ảnh trong thư mục ROOT -->
	
	        </div>
	        <!--Grid column-->
	
	        <!--Grid column-->
	        <div class="col-md-6 mb-4">
	
	          <!--Content-->
	          <div class="p-4" >

	            <h3>${product.name}</h3>
	            <p>${product.description}</p>
	            <p><b>Item Code:</b> ${product.id} </p>
	            <p><b>Manufacturer:</b> ${product.manufacturer} </p>
	           	
	            <p><b>Availble units in stock:</b> ${product.quantity}</p>
	            <p><b>Price:</b> ${product.price} USD</p>
	            <a href="${pageContext.request.contextPath }/productList " class="btn btn-success">
          				<span class="glyphicon glyphicon-circle-arrow-left"></span> Back
        		</a>
        		<a href="${pageContext.request.contextPath }/cart?action=add&id=${product.id}" class="btn btn-warning">
          				<span class="glyphicon glyphicon-shopping-cart"></span> Order Now
        		</a>	
	          </div>
	          <!--Content-->
	
	        </div>
	        <!--Grid column-->
	
	      </div>
	   </div>
	</main>
     
</body>
</html>