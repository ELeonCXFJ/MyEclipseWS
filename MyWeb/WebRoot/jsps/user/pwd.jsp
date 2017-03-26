<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   	<meta charset="utf-8"> 
   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<title>修改密码</title>

   	<link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css" />  
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrapValidator.css" /> 
   	
   	<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
   	<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/bootstrapValidator.js"></script>


</head>

  
<body>
	<div class="container">
			<div class="row clearfix">
			<c:import url="../../top.jsp"></c:import>
			<h3 align="center">修改密码</h3>
				<div class="col-md-12 column">
				<div class="col-md-4 column"></div>
				
				<div class="col-md-4 column">
				<!-- mainform 开始 -->
					<form id="mainform" role="form" method="POST" action="<c:url value='/UserServlet'/>">
					<input type="hidden" name="method" value="updatePassword" />
						
						<div class="form-group">
							<label for="password">密码</label>
							<input type="password" name="password" class="form-control" id="password" placeholder="请输入密码" />
						</div>
						
						<div class="form-group">
							<label for="newpassword">新密码</label>
							<input type="password" name="newpassword" class="form-control" id="password" placeholder="请输入新密码" />
						</div>
						
						<div class="form-group">
							<input type="password" name="confirmpassword" class="form-control" id="password" placeholder="请再次输入新密码" />
						</div>
						<c:choose>
							<c:when test="${requestScope.code == 'NOT_LOGIN' }">
								${msg }
							</c:when>
							<c:when test="${requestScope.code == 'SUCCESS' }">
								<div class="alert alert-success">修改密码成功</div>
							</c:when>
							<c:when test="${requestScope.code == 'ERROR' }">
								<div class="alert alert-danger">原密码错误</div>
							</c:when>
						</c:choose>
						</br>
						<div align="center"><button type="submit" class="btn btn-primary">修改密码</button></div>
					</form>
				<!-- mainform 结束！ -->
				</div>
				
				</div>
			</div>
		</div>
		<c:import url="../../bottom.jsp"></c:import>
<script	type="text/javascript">
			
	$("#mainform").bootstrapValidator({
			message:"this value is not valid",
			feedbackIcons:{
			valid:'glyphicon glyphicon-ok',
			invalid:'glyphicon glyphicon-remove',
			validating:'glyphicon glyphicon-refresh'
		},
		fields:{
			password:{
				validators:{
					notEmpty:{
						message:"原密码不能为空"
					},
					stringLength:{
						min:5,
						max:20,
						message:"密码长度必须在5-20个字符之间"
					}
				}
			},
			newpassword:{
				validators:{
					notEmpty:{
						message:"新密码不能为空"
					},
					stringLength:{
						min:5,
						max:20,
						message:"密码长度必须在5-20个字符之间"
					},
					identical:{
						field: 'confirmpassword',
						message: '两次输入的密码不相同',
					},
					different:{
						field: 'password',
						message:'用户密码不能和原密码相同'
					},
				}	
			},
			confirmpassword:{
				validators:{
					notEmpty:{
						message:"新密码不能为空"
					},
					stringLength:{
						min:5,
						max:20,
						message:"密码长度必须在5-20个字符之间"
					},
					identical:{
						field: 'newpassword',
						message: '两次输入的密码不相同',
					},
					different:{
						field: 'password',
						message:'用户密码不能和原密码相同'
					},
				}	
			}
		}
		
	});
</script>
</body>
</html>
