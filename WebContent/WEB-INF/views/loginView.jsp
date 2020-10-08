<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title >Login</title>
</head>
<style>

</style>
</head>
<body>
	<div class="store-name" style="background: #E0E0E0; height: 105px; padding: 5px; padding-left: 5%; font-size: 400%">
		<p>Mobile store</p>
	</div>
	<form method="POST" action="${pageContext.request.contextPath}/login">
		<div class="container" style="padding-top: 5%;">
		    <div class="row">
				<div class="col-md-4 col-md-offset-4">
		    		<div class="panel panel-default">
					  	<div class="panel-heading">
					    	<h3 class="panel-title">Please sign in</h3>
					 	</div>
					  	<div class="panel-body">
					    	<form accept-charset="UTF-8" role="form">
		                    <fieldset>
					    	  	<div class="form-group">
					    		    <input class="form-control" placeholder="User Name" name="userName" type="text" value="${user.userName}" >
					    		</div>
					    		<div class="form-group">
					    			<input class="form-control" placeholder="Password" name="password" type="password" value="" value="${user.password}" >
					    		</div>
					    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
					    	</fieldset>
					      	</form>
					    </div>
					</div>
				</div>
			</div>
		</div>
	</form>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>