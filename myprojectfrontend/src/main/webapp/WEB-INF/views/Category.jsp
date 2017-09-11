<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link  href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
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
<title>categorypage </title>


<c:if test="${check}">
<form:form class="form-horizontal" action="addCategory" method="post" modelAttribute="getCategory">
<fieldset>

<!-- Form Name -->
<legend>CATEGORY</legend>

<!-- Select Basic -->

<br>
<br>
<br>
<br>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">CATEGORY NAME </label>
  <div class="col-md-4">
      <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="name"/>
    </select>
  </div>
</div>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">DESCRIPTION</label>
  <div class="col-md-4">
      <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="description"/>
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
<form:form class="form-horizontal" action="updCategory" mothed="post" modelAttribute="getCategory">
<fieldset>

<!-- Form Name -->
<legend>CATEGORY</legend>

<!-- Select Basic -->

<br>
<br>
<br>
<div class="form-group">

  <div class="col-md-4">
     <form:input id="textinput" name="textinput" type="hidden" placeholder="" class="form-control input-md" path="id"/>
    </select>
  </div>
</div>
<br>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">CATEGORY NAME </label>
  <div class="col-md-4">
      <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="name"/>
    </select>
  </div>
</div>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="category_name_fr">DESCRIPTION</label>
  <div class="col-md-4">
      <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="description"/>
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
				<td>Category Id</td>
				<td>Category Name</td>
				<td>Category Description</td>
				<td>Edit/Delete</td>
			</tr>
		</thead>
 
		<tbody>
			<c:forEach items ="${cattable}" var="k">
				<tr>
					<td>${k.getId()}</td>
					<td>${k.getName()}</td>
					<td>${k.getDescription()}</td>
					
					<td>
					<div>
<a class="btn icon-btn btn-success" href="Editcat?catid=${k.getId()}"><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Edit</a>
<a class="btn icon-btn btn-danger" href="delcat/${k.getId()}"><span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Delete</a>
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
  