<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="store-name" style="background: #E0E0E0; padding: 2%" >
		<p style="font-size: 400%">Cart</p>
		<p>All the selected products in your cart</p>
	</div>
	<div class="container" style="padding-top: 2%">
	    <div class="row">
	        <div class="col-sm-12 col-md-10 col-md-offset-1">
	            <table class="table table-hover">
	                <thead>
	                <tr>
		                <a href="${pageContext.request.contextPath }/cart?action=clear " class="btn btn-danger" >
	          				<span class="glyphicon glyphicon-remove-sign"></span> Clear Cart
	        			</a>
	        			<a href="#" class="btn btn-success" style="float: right;" >
	          				<span class="glyphicon glyphicon-shopping-cart"></span> Check out 
	        			</a>

	                </tr>
	                    <tr>
	                        <th>Product</th>
	                        <th>Quantity</th>
	                        <th class="text-center">Unit Price</th>
	                        <th class="text-center">Price</th>
	                        <th class="text-center">Action</th>
	                        <th> </th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<c:set var="total" value="${0}"/>
	                	<c:forEach items="${sessionScope.cart}" var="i">
		                    <tr>
		                        <td class="col-sm-9 col-md-5">
		                        <div class="media">	                         
		                            <div class="media-body">
		                                <h4 class="media-heading"><a href="${pageContext.request.contextPath}/productDetails?id=${i.product.id}">${i.product.name}</a></h4>
		                            </div>
		                        </div></td>
		                        <td class="col-sm-1 col-md-1" style="text-align: center">
		                        <p>${i.quantity}</p>
		                        </td>
		                        <td class="col-sm-5 col-md-3 text-center"><strong>${i.product.price}</strong></td>
		                        <td class="col-sm-1 col-md-1 text-center"><strong>${i.product.price * i.quantity}</strong></td>
		                        	<c:set var="total" value="${total + i.product.price * i.quantity}" />
		                        <td class="col-sm-1 col-md-1">
		                        <a href="${pageContext.request.contextPath }/cart?action=remove" class="btn btn-danger">
		                            <span class="glyphicon glyphicon-remove"></span> Remove
		                        </a></td>
		                    </tr>
		                    
		            	</c:forEach>     	
						    
		            	<tr>
		                	<td>   </td>
		                    <td>   </td>
		                    <td><h3>Grand Total</h3></td>
		                    <td class="text-right"><h3><strong>${total} </strong></h3></td>
		                    <td>   </td>
		                    <td>   </td>
		                        
		                </tr>
	                </tbody>
	            </table>
	            <a href="${pageContext.request.contextPath }/productList " class="btn btn-success" >
	          		<span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
	        	</a>
	        </div>
	    </div>
	</div>
</body>
</html>