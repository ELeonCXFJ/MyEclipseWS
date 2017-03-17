<%@ page trimDirectiveWhitespaces="true" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <title>在线家政服务系统主页</title>
   <link rel="stylesheet" href="./vendor/bootstrap/css/bootstrap.min.css">  
   <script src="./vendor/jquery/js/jquery.min.js"></script>
   <script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<div class="row clearfix">
	<c:import url="top.jsp" />
		<div class="col-md-12 column">

			<div class="jumbotron">
				<h1>
					Hello, world!
				</h1>
				<p>
					This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
				</p>
				<p>
					 <a class="btn btn-primary btn-large" href="#">Learn more</a>
				</p>
			</div>
		</div>
	</div>
	<c:import url="bottom.jsp"></c:import>
</div>
</body>
</html>
