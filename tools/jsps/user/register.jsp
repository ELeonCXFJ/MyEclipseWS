<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   	<meta charset="utf-8"> 
   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<title>用户注册</title>

   	<link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.css" />  
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrapValidator.css" /> 
   	
   	<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
   	<script type="text/javascript" src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/bootstrapValidator.js"></script>

</head>

<body>
<div class="container" >

<div>

</div>

<div class="jumbotron well">
	<h2 align="center">在线家政服务系统</h2>
	<h3 align="center">用户注册页面</h3></br></br>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
		</div>
		
		<div class="col-md-4 column">
			<form id="mainform" action="<c:url value='/UserServlet'/>" method="post" role="form">
				<input type="hidden" name="method" value="register"/>
				<div class="form-group">
					 <label for="username">用户名</label>
					 <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名" />
				</div>
				
				<div class="form-group">
					 <label for="password">密码</label>
					 <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"  />
				</div>
				
				<div class="form-group">
					 <label for="confirmpassword">重复密码</label>
					 <input type="password" name="confirmpassword" class="form-control" id="confirmpassword" placeholder="请再次输入密码"  />
				</div>
				
				<div class="form-group">
					 <label for="email">电子邮箱</label>
					 <input type="text" name="email" class="form-control" id="username" placeholder="请输入电子邮箱"/>
				</div>
				
				<button type="submit" class="btn btn-primary">注册</button>
			</form>
		</div>
		
		<div class="col-md-4 column">
		</div>
	</div>
</div>
	<div>
		<label for=“bottom">2017毕业设计</br>薛付俊 201320311010</br>指导老师：焦佳佳</label>
	</div>
	<div style="display:none;">
		<label for="hide">bootstrapvalidator引用自：https://github.com/nghuuphuoc/bootstrapvalidator</label>
	</div>
<div>
</div>
</div>
<script type="text/javascript">
$("#mainform").bootstrapValidator({
	message:"This value is not valid",
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
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
						message:"用户名长度必须在6-20个字符之间"
					},
					regexp:{
						regexp:/^[a-zA-Z0-9_\.]+$/,
						message:"用户名只能由字母、数字、点和下划线组成",
					},
				}
			},
			
			password:{
				validators:{
					notEmpty:{
						message:'密码不能为空'
					},
					identical:{
						field: 'confirmpassword',
						message: '两次输入的密码不相同',
					},
					different:{
						field: 'username',
						message:'用户密码不能和账户名相同'
					},
					stringLength:{
						min:5,
						max:20,
						message:"密码长度必须在5-20个字符之间"
					},
				}
			},
			
			confirmpassword:{
				validators:{
					notEmpty:{
						message:'请重复输入密码'
					},
					identical:{
						field: 'password',
						message: '两次输入的密码不相同',
					},
					different:{
						field: 'username',
						message:'用户密码不能和账户名相同'
					},
					stringLength:{
						min:5,
						max:20,
						message:"密码长度必须在5-20个字符之间"					
					},
				}
			},
			
			email:{
				validators:{
					emailAddress:{
						message:"当前输入的邮箱格式有误，请确认该邮箱为有效邮箱地址"
					},
					notEmpty:{
						message:'电子邮箱不能为空'
					}
				}
			}
        }
});
</script>
</body>
</html>