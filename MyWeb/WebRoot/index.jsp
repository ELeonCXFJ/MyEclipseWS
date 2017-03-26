<%@ page trimDirectiveWhitespaces="true" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <title>在线家政服务系统主页</title>
   <script src="./vendor/jquery/jquery.min.js"></script>
   <script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="./vendor/bootstrap/css/bootstrap.min.css" />  

</head>
<body>
<c:if test="${requestScope.code == 'ORDER_SUCCESS' }">
	<!-- 模态框（Modal） -->
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
					预约成功，请等待我们与您联系。
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">确定
					</button>
				</div>
			</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
		<script>
		$("#alertModal").modal('show');
		</script>
</c:if>
<div class="container">
	<div class="row clearfix">
	<c:import url="top.jsp" />
		<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
		
		<div class="col-lg-2 col-md-2 col-xs-2 col-sm-2 center">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="<c:url value='/jsps/product/keeper/dailywork.jsp'/>">日常保洁</a></li>
				<li><a href="#">深度保洁</a></li>
				<li><a href="#">开荒保洁</a></li>
				<li><a href="#">空调清洗</a></li>
				<li><a href="#">地板打蜡</a></li>
				<li><a href="#">月嫂服务</a></li>
				<li><a href="#">联系我们</a></li>
			</ul>
		</div>
		
		<div class="col-lg-10 col-md-10 col-xs-10 col-sm-10 center">
		<!-- 轮播组件开始---------------------------- -->
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="5000">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   
	<!-- 轮播（Carousel）项目 -->
	<div  class="carousel-inner">
		<div class="item active">
			<img width=100% src="<c:url value='/adv_img/slide1.jpg'/>" alt="First slide">
		</div>
		<div class="item">
			<img src="<c:url value='/adv_img/slide2.jpg'/>" alt="Second slide">
		</div>
		<div class="item">
			<img src="<c:url value='/adv_img/slide3.jpg'/>" alt="Third slide">
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next">&rsaquo;</a>
			</div>	
		<!-- 轮播组件结束---------------------------- -->
		</div>
		</div>
	</div>
		
	</div>
	<c:import url="bottom.jsp"></c:import>
</body>
</html>
