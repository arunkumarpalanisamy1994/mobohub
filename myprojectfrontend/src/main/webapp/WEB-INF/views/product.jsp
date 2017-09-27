<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link 
	href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<script>
	$(document).ready(function() {
		$('#table_id').dataTable({
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ]
		});
	});
</script>
<div style="margin-bottom: -15pt">
<jsp:include page="navbar.jsp"></jsp:include>
</div>
<style>
.btn-glyphicon { padding:8px; background:#ffffff; margin-right:4px; }
.icon-btn { padding: 1px 15px 3px 2px; border-radius:50px;}
</style>
<div class="container">
<legend> PRODUCT DETAILS</legend>
<br>
<br>

  <c:if test="${check}">  
    <form:form class="form-horizontal" action="addproduct" modelAttribute="getproduct" enctype="multipart/form-data">
<fieldset>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Product name</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="name"/>
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">Description</label>
  <div class="col-md-4">                     
   <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="description"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Price</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="number" placeholder="" class="form-control input-md" path="price" onkeypress="return event.charCode >= 48" min="1"/>
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Quantity</label>
  <div class="col-md-4">
    <form:input id="textinput" name="textinput" type="number" placeholder="" class="form-control input-md" path="quantity" onkeypress="return event.charCode >= 48" min="1"/> 
    </select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Supplier name</label>  
  <div class="col-md-4">
  
     <form:select path="Suppliername" class="form-control">
					<c:forEach items="${suptable}" var="x">
						<c:set var="nam" value="${x.getName()}"/>
						<form:option value="${nam}">${nam}</form:option>
					</c:forEach>
					</form:select>
    
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Category name</label>  
  <div class="col-md-4">
  
     <form:select path="categoryname" class="form-control">
					<c:forEach items="${cattable}" var="x">
						<c:set var="nam" value="${x.getName()}"/>
						<form:option value="${nam}">${nam}</form:option>
					</c:forEach>
					</form:select>
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">ProductImage</label>  
  <div class="col-md-4">
  <form:input id="file" name="textinput" type="file" placeholder="" class="form-control input-md" path="productImage"/>    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">ADD</button>
  </div>
</div>

</fieldset>
</form:form>
 </c:if>
 <c:if test="${!check}">
  <form:form class="form-horizontal" action="updproduct" modelAttribute="getproduct" enctype="multipart/form-data">
<fieldset>

<!-- Form Name -->

<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Product ID</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="id"/>
    
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Product name</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="name"/>
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">Description</label>
  <div class="col-md-4">                     
   <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="description"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Price</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="number" placeholder="" class="form-control input-md" path="price" onkeypress="return event.charCode >= 48" min="1"/>
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Quantity</label>
  <div class="col-md-4">
    <form:input id="textinput" name="textinput" type="number" placeholder="" class="form-control input-md" path="quantity" onkeypress="return event.charCode >= 48" min="1"/> 
    </select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Supplier name</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="Suppliername"/>
       
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Category name</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="categoryname"/>
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">ProductImage</label>  
  <div class="col-md-4">
  <form:input id="file" name="textinput" type="file" placeholder="" class="form-control input-md" path="productImage"/>    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">update</button>
  </div>
</div>

</fieldset>
</form:form>
</c:if>

<div>
	<table id="table_id" class="table table-bordered">
		<thead>
			<tr>
			<td>Product Image</td>
				<td>product Id</td>
				<td>product Name</td>
				<td>Description</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>Supplier name</td>
				<td>Category name</td>
				<td>Edit/Delete</td>
				
			</tr>
		</thead>
 
		<tbody>
			<c:forEach items="${protable}" var="m">
				<tr>
					<td class""><img style="vertical-align: bottom;" width="25" height="60" src="resources/productImages/${m.getId()}.jpg"/></td>
					<td>${m.getId()}</td>
					<td>${m.getName()}</td>
					<td>${m.getDescription()}</td>
					<td>${m.getPrice()}</td>
					<td>${m.getQuantity()}</td>
					<td>${m.getSuppliername()}</td>
					<td>${m.getCategoryname()}</td>
				
				<td>
					<div>
<a class="btn icon-btn btn-success" href="Editpro?proid=${m.getId()}"><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit</a>
<a class="btn icon-btn btn-danger" href="delpro/${m.getId()}"><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
</div>
</td>
</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<br>
<br>
<br>
<jsp:include page="footer.jsp"></jsp:include>
