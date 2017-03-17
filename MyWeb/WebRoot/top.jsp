<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <title>导航栏</title>
</head>
<body>

<div class="container" align="center">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="<c:url value='/index.jsp'/>">在线家政服务系统</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li >
							 <a href="#">Link</a>
						</li>
						<li>
							 <a href="#">Link</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="#">Action</a>
								</li> 
								<li>
									 <a href="#">Another action</a>
								</li>
								<li>
									 <a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">Separated link</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">One more separated link</a>
								</li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty sessionScope.sessionUser }">
						<li>
							 <a href="<c:url value='/jsps/user/register.jsp'/>">注册</a>
						</li>
						<li>
							<a href="<c:url value='/jsps/user/login.jsp' />">登录</a>
						</li>						
						</c:when>
						
						<c:otherwise>
								<li>
									 <a href="#">我的订单</a>
								</li>
								<li>
									 <a href="#">修改密码</a>
								</li>
								<li>
									 <a href="#">购物车</a>
								</li>
								<li>
									<a href="#">退出</a>
								</li>						
						</c:otherwise>
					</c:choose>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</div>
</body>