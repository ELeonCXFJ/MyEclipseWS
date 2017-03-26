<%@ page trimDirectiveWhitespaces="true" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <title>日常保洁</title>
   <script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
   <script src="<c:url value='/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
   <link rel="stylesheet" href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css'/>" />  

</head>
<body>

<div class="container">
	<div class="row clearfix">
	<c:import url="/top.jsp" />
	<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
		<ol class="breadcrumb">
		    <li><a href="<c:url value='/index.jsp'/>">主页</a></li>
		    <li class="active">日常保洁</li>
		</ol>
	</div>
		<div class="col-md-1"></div>
		<div class="col-lg-10 col-md-10 col-xs-10 col-sm-10">
			<h2>日常保洁·<small>专业标准化上门清洁服务</small></h2>
			<br/>
			<h3>价格透明</h3>
			<hr>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<p align="center">价目表</p>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th width="40%">时长</th>
								<th>价格</th>
							</tr>
						</thead>
						<tr>
							<td>2小时</td>
							<td>60~70元</td>
						</tr>
						<tr>
							<td>2.5小时</td>
							<td>75~87.5元</td>
						</tr>
						<tr>
							<td>3小时</td>
							<td>90~105元</td>
						</tr>
						<tr>
							<td>3.5小时</td>
							<td>105~122.5元</td>
						</tr>
						<tr>
							<td>4小时</td>
							<td>120~140元</td>
						</tr>
					</table>
				</div>
			</div>
		<blockquote><small>注：如使用XX牌清洁剂，每小时多加收5元。</small></blockquote>
			<div class="text-muted">gray</div>
			<div class="text-primary">blue</div>
			<div class="text-success">green</div>
			<div class="text-info">blue</div>
			<div class="text-warning">yellow</div>
			<div class="text-danger">red</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<p align="center">参考用时</p>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th width="40%">户型</th>
								<th>参考用时</th>
							</tr>
						</thead>
						<tr>
							<td>一居室</td>
							<td>2~3.5小时</td>
						</tr>
						<tr>
							<td>两居室</td>
							<td>3~4.5小时</td>
						</tr>
						<tr>
							<td>三居室</td>
							<td>4~5.5小时</td>
						</tr>
						<tr>
							<td>四居室及以上</td>
							<td>五小时以上</td>
						</tr>
					</table>
				</div>
			</div> <!-- 参考时长 -->
		<blockquote><small>注：不同户型及油污、积灰面积会影响打扫时长，以上打扫时长仅供您参考。</small></blockquote>
		</br>	
		<h3>服务范围</h3>	
		<hr>
		<table class="table table-bordered">
			<tr>
				<td align="center">
					<h4>整体清洁范围</h4>
					<p class="text-muted">
						物品归位整理、无覆盖物地面清洁</br>
						内窗清洁、更换垃圾袋</br>
						床底、柜底除尘、家具家电表面清洁</br>
						门表面及把手、墙面、踢脚线除尘</br>
						</p>
				</td>
				<td align="center">
					<h4>客厅、卧室</h4>
					<p class="text-muted">
						床铺整理</br>
						地毯除尘</br>
						地垫除尘</br>
						沙发除尘整理</br>
					</p>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h4>卫浴</h4>
					<p class="text-muted">
						马桶清洁</br>
						 镜子、五金件清洁</br>
						 浴缸、淋浴房清洁</br>
					</p>
				</td>
				<td align="center">
					<h4>厨房</h4>
					<p class="text-muted">
						油烟机表面除尘</br>
						油盒清洗</br>
						水池、五金件、灶台表面清洁</br>
						餐具、厨具清洁</br>
					</p>
				</td>
			</tr>
		</table>
		<div align="center">
			<form method="post" action="<c:url value='/OrderServlet'/>">
				<input type="hidden" name="method" value="doOrderLink" />
				<button type="submit" class="btn btn-primary"  >立即预约</button>
			</form>
		</div>
	</div>
	</div>
</div>	<!-- container -->
	<c:import url="/bottom.jsp"></c:import>
</body>
</html>
