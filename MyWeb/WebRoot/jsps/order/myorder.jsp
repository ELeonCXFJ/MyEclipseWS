<%@ page trimDirectiveWhitespaces="true" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="Content-Type" conteng="text/html" charset="utf-8"> 
   <title>我的订单</title>
	<script type="text/javascript" src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
	
	<link rel="stylesheet" href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css'/>" />
	<script type="text/javascript">
		function showInfo(){
			alert("ri");
			$('#alertModal').modal({backdrop:'static',keyboard:false});
			$('#alertModal').modal('show');
			<% request.removeAttribute("pay_status"); %>						
		}

	</script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
	<input type="hidden" name="method" value="getMyOrder" id="getMyOrder">
	<c:if test="${requestScope.pay == 'SUCCESS' }">
	
	<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						来自开发者的消息
					</h4>
				</div>
				<div class="modal-body">
					您的订单支付成功，订单id为${oid },欢迎下次继续使用。
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">确定
					</button>
				</div>
			</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
		<script>
			$('#alertModal').modal({backdrop:'static',keyboard:false});
			$('#alertModal').modal('show');
			$('#alertModal').modal('hide.bs.modal',function(){
			var xmlhttp;    
			  if (window.XMLHttpRequest)
			  {
			    // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			    xmlhttp=new XMLHttpRequest();
			  }
			  else
			  {
			    // IE6, IE5 浏览器执行代码
			    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			  xmlhttp.open("POST","/OrderServlet?getMyOrder"+str,false);
			  xmlhttp.send();
			});
		</script>
	<c:remove var="pay" scope="request"/>
	</c:if>

	<c:import url="/top.jsp" />
		<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
		<h2>我的订单</h2>
			<table id="order" name="order" class="table table-hover">
				<thead>
					<tr>
						<th width="10%">服务名称</th>
						<th width="15%">预约时间</th>
						<th width="15%">下单时间</th>
						<th width="30%">地址</th>
						<th width="10%">订单状态</th>
						<th width="10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderList }" var="order">
						<tr>
							<td width="20%">${order.service }</td>
							<td>${order.appointment }</td>
							<td>${order.ordertime }</td>
							<td>上海市 ${order.district }&nbsp;${order.street }</td>
							<td>
								<c:if test="${order.status == 0}">
									<div class="text-danger">未支付</div>
								</c:if>
								<c:if test="${order.status == 1}">
									<div class="text-success">已完成</div>
								</c:if>								
							</td>
							<td>
								<c:if test="${order.status == 1}">
									<a href="<c:url value='/OrderServlet?method=checkOrderDetail&oid=${order.oid }'/>">查看详情</a>
								</c:if>
								<c:if test="${order.status == 0}">
									<a href="<c:url value='/OrderServlet?method=doPay&oid=${order.oid }'/>">立即支付</a>
								</c:if>							
							</td>
						</tr>
					</c:forEach>					
				</tbody>
			</table>			
       	</div>
       	
	</div>
</div>	<!-- container -->
	<c:import url="/bottom.jsp"></c:import>


</body>
</html>
