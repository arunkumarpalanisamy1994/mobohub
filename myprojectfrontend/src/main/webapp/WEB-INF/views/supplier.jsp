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
<c:if test="${check}">
<form:form class="form-horizontal" action="addsupplier" method="post" modelAttribute="getsupplier">
<fieldset>

<!-- Form Name -->
<legend> SUPPLIER DETAILS</legend>

<!-- Select Basic -->

<br>
<br>
<br>
<br>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">SUPPLIER NAME </label>
  <div class="col-md-4">
      <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="name"/>
    </select>
  </div>
</div>
<br>
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">SUPPLIER ADDRESS </label>
  <div class="col-md-4">
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="Address"/>  
    </select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name">SUPPLIER phone number</label>
  <div class="col-md-4">
     <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="phonenumber"/>
    </select>
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">Submit</button>
  </div>
</div>

</fieldset>
</form:form>
</c:if>
<c:if test="${!check}">
<form:form class="form-horizontal" action="updsupplier" method="post" modelAttribute="getsupplier">
<fieldset>

<!-- Form Name -->
<legend> SUPPLIER DETAILS</legend>

<!-- Select Basic -->

<br>
<br>
<br>
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name">SUPPLIER ID</label>
  <div class="col-md-4">
     <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="id"/>
    </select>
  </div>
</div>
<br>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">SUPPLIER NAME </label>
  <div class="col-md-4">
      <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="name"/>
    </select>
  </div>
</div>
<br>
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">SUPPLIER ADDRESS </label>
  <div class="col-md-4">
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="Address"/>  
    </select>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name">SUPPLIER phone number</label>
  <div class="col-md-4">
     <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="phonenumber"/>
    </select>
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">update</button>
  </div>
</div>

</fieldset>
</form:form>
</c:if>

<div>
	<table id="table_id" class="table table-bordered">
		<thead>
			<tr>
				<td>supplier Id</td>
				<td>supplier Name</td>
				<td>supplier Address </td>
				<td>supplier phonenumber</td>
				<td>Edit/Delete</td>
				
			</tr>
		</thead>
         <tbody>
			<c:forEach items="${suptable}" var="l">
				<tr>
					<td>${l.getId()}</td>
					<td>${l.getName()}</td>
					<td>${l.getAddress()}</td>
					<td>${l.getPhonenumber()}</td>
					<td>
				<div>
<a class="btn icon-btn btn-success" href="Editsup?supid=${l.getId()}"><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit </a>
<a class="btn icon-btn btn-danger" href="delsup/${l.getId()}"><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
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

  
  
  