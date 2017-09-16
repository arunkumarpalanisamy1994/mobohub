<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="navbar.jsp"></jsp:include>

<style>
.thumbnail:hover{
		opacity:1.00;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
		transition: box-shadow 0.5s; 
		
		}
</style>
<body>

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
      				<a href="addtocart/${m.getId()}"><button class="btn btn-success right" > Add to Cart</button></a>	
      				</div>
      				
      			</div>
    		</span>
  		</div>
  		</c:forEach>
  		</body>
  		<jsp:include page="footer.jsp"></jsp:include>
