<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   	<meta charset="utf-8"> 
   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<title>用户登录</title>

   	<link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css" />  
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrapValidator.css" /> 
   	
   	<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
   	<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/bootstrapValidator.js"></script>

</head>

  
<body>
	<div class="container">
		<div class="jumbotron well">
			<h2 align="center">在线家政服务系统</h2>
			<h3 align="center">用户登录页面</h3>
			</br>
			</br>
			<div class="row clearfix">
				<div class="col-md-12 column"></div>
			</div>
			<div class="row clearfix">
				<div class="col-md-4 column"></div>
				<div class="col-md-4 column">
					<form id="mainform" role="form" method="POST" action="<c:url value='/UserServlet'/>">
					<input type="hidden" name="method" value="login" />
						<div class="form-group">
							<label for="username">用户名</label>
							<input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
						</div>

						<div class="form-group">
							<label for="password">密码</label>
							<input type="password" name="password" class="form-control" id="password" placeholder="请输入密码" />
						</div>
						</br>
						<div align="center"><button type="submit" class="btn btn-primary">登录</button></div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script	type="text/javascript">
	$("#mainform").bootstrapValidator({
			message:"this value is not valid",
			feedbackIcons:{
			valid:'glyphicon glyphicon-ok',
			invalid:'glyphicon glyphicon-remove',
			validating:'glyphicon glyphicon-refresh'
		},
		fields:{
			username:{
				validators:{
					notEmpty:{
						message:'用户名不能为空'
					},
					stringLength:{
						min:6,
						max:20,
						message:'用户名长度必须在6-20个字符之间'
					},
					regexp:{
						regexp:/^[a-zA-Z0-9_\.]+$/,
						message:"用户名只能由字母、数字、点、下划线组成"
					}
				}
			},
			password:{
				validators:{
					notEmpty:{
						message:"密码不能为空"
					},
					stringLength:{
						min:5,
						max:20,
						message:"密码长度必须在5-20个字符之间"
					}
				}
			}
		
		}
		
	});
</script>
</body>
</html>
