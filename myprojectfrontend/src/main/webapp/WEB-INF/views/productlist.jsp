<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>W3.CSS</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.thumbnail:hover{
		opacity:1.00;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
		transition: box-shadow 0.5s;
		
		}
</style>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
	<div class="row">
    	<!-- BEGIN PRODUCTS -->
    	<c:forEach items="${protable}" var="m">
  		<div class="col-md-3 col-sm-6">
    		<span class="thumbnail text-center">
      			<img src="resources/productImages/${m.getId()}.jpg">
      			<h4 class="text-danger">${m.getName()}</h4>
      			<p>${m.getPrice()}</p>
      			



      			<hr class="line">
      			<div class="row">
      				<div class="col-md-6 col-sm-6">
      				<a href="hehe?id=${m.getId()}">	<button type="button" class="btn btn-info" >View Product</button></a>
      				</div>
      				<div class="col-md-6 col-sm-6">
      					<button class="btn btn-success right" > Add to Cart</button>
      				</div>
      				
      			</div>
    		</span>
  		</div>
  		</c:forEach>
  		<jsp:include page="footer.jsp"></jsp:include>
</body>