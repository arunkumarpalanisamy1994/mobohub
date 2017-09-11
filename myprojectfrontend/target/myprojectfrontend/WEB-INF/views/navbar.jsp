<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="shortcut icon" href="resources/images/Mobile.ico"/>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body >
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">MoboHub</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" style="float:right";>
      <ul class="nav navbar-nav">
        <li><a href="home">Home</a></li>
        <li class="dropdown">
      	  
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="contact">Contactus</a></li>
        <li><a href="aboutus">Aboutus</a></li>
        <li><a href="product Add">products</a></li>
        <c:if test ="${sessionScope.username==null}">
        <li><a href="signin">Sign in</a></li>
        </c:if>
        <c:if test ="${sessionScope.username!=null}">
        <c:if test ="${sessionScope.username=='admin'}">
        <li><a href="Category">CategoryAdd</a></li>
		<li><a href="supplier">supplierAdd</a></li>
		<li><a href="product">productAdd</a></li>
		<li><a href="multiple product add">products</a></li>
		</c:if>
		<li><a href="" style="text-transform: capitalize;"><span>Welcome </span>${sessionScope.username}</a></li>
		<li><a href="logout"><span class="glyphicon glyphicon-user"></span>Logout</a></li>
		</c:if>
		<li><a href="#">Carts</a></li>
      </ul>
    </div>
  </div>
</nav>
  


</body>
</html>
