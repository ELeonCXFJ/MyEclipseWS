<%@ page trimDirectiveWhitespaces="true" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <title>地址管理</title>
   <script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
   <script type="text/javascript" src="<c:url value='dist/js/bootstrapValidator.js'/>"></script>
   <script src="<c:url value='/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
   
   <link rel="stylesheet" href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css'/>" />  
   <link rel="stylesheet" href="<c:url value='/dist/css/bootstrapValidator.css'/>"/>
   
</head>
<body>

<div class="container">
	<div class="row clearfix">
	<c:import url="/top.jsp" />
	<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
		<div class="col-md-1"></div>
		<div class="col-lg-10 col-md-10 col-xs-10 col-sm-10">
			<form id="mainform" method="post" action="<c:url value='/UserServlet'/>" role="form">
			<input type="hidden" name="method" value="addAddress">
				<div class="form-group">
		            <div class="col-md-3">
		   				<label for="city">上海市</label>
		                <select class="form-control" name="district" id="district">
		                    <option value="" >--选择所在的区--</option>
		                    <option value="浦东新区">浦东新区</option>
		                    <option value="黄浦区">黄浦区</option>
		                    <option value="静安区">静安区</option>
		                    <option value="闵行区">闵行区</option>
		                    <option value="徐汇区">徐汇区</option>
		                    <option value="金山区">金山区</option>
		                    <option value="宝山区">宝山区</option>
		                </select>
		                </br>
		            </div>
		         </div>
		         
	            <div class="col-md-7">
	            	<div class="form-group">	            
	            	<label for="street">详细地址</label>
	               		<input type="text" name="street" class="form-control" id="street" placeholder="请输入详细地址"/>
	                </div>
	           		<div class="form-group">
	                <label for="tel">手机号</label>
	           			<input type="text" name="tel" class="form-control" id="tel" placeholder="请输入手机号"/>
					</div>	            
	            	<button type="submit" class="btn btn-primary">添加</button>  
	            </div>

            </form>
		</div>	
		
		<div class="col-lg-1 col-md-1 col-xs-1 col-sm-1">
		</div>
	</div>
	<blockquote><small>注：地区目前仅支持上海</small></blockquote>		
	</div>
	
</div>	<!-- container -->
	<c:import url="/bottom.jsp"></c:import>

<script	type="text/javascript">
	$("#mainform").bootstrapValidator({
			message:"this value is not valid",
			feedbackIcons:{
			valid:'glyphicon glyphicon-ok',
			invalid:'glyphicon glyphicon-remove',
			validating:'glyphicon glyphicon-refresh'
		},
		fields:{
			district:{
				validators:{
					notEmpty:{
						message:'请选择区'
					},
				}
			},
			street:{
				validators:{
					notEmpty:{
						message:"请填写街道地址"
					},
				}
			},
			tel:{
				validators:{
					notEmpty:{
						message:"请填写手机号"
					}
				}
			}
		}
		
	});
</script>

</body>
</html>
