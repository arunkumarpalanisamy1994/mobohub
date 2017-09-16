<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="navbar.jsp"></jsp:include>
<style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
</style>
<body>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th></th>
							<th style="width:8%">Quantity</th>
							<th></th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
							
						</tr>
					</thead>
					<c:forEach items="${protable}" var="m">
					<tbody>
				
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="resources/productImages/${m.getProdid()}.jpg" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${m.getProdname() }</h4>
										
									</div>
								</div>
							</td>
							<td data-th="Price">Rs. <span>${m.getPrice() }</span></td>
							<td><a href="redcart?getprodid=${m.getProdid() }"><button class="btn btn-info btn-sm">-</button></a></td>
							<td data-th="Quantity">
							
								<input type="number" class="form-control text-center" value="${m.getQuantity() }">
								
							</td>
							<td><a href="inccart?getprodid=${m.getProdid() }"><button class="btn btn-info btn-sm">+</button></a></td>
							<td data-th="Subtotal" class="text-center">Rs.<span>${m.getTotal()}</span></td>
							
							<td >
								<a href="delcartprod/${m.getId() }"><button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button></a>								
							</td>
						</tr>
						</form>
					</tbody>
					</c:forEach>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total 1.99</strong></td>
						</tr>
						<tr>
							<td><a href="productlist" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total Rs.${total}</strong></td>
							<c:if test="${sessionScope.prodtotal>0}">
							<td><a href="checkout" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
							</c:if>
						</tr>
					</tfoot>
				</table>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>