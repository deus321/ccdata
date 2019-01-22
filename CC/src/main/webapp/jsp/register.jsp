<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrapValidator.css"/>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<script>
	$(function(){
		$("#username").blur(function(){
			var username = $(this).val();
			if(username != ""){
				$.ajax({
					url:"${pageContext.request.contextPath}/UserServlet",
					data:{"method":"checkUsername","username":username},
					type:"Post",
					success:function(data){
						if(data.result == "成功"){
							$("#redwarning").html("该用户名已注册，请重输！").css("color","red");
						}else if(data.result == "失败"){
							$("#redwarning").html("该用户名未注册，请注册！").css("color","green");
						}
				}});
			}
		});
	
	});

</script>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/jsp/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;" action="${pageContext.request.contextPath}/UserServlet?method=regist" method="post">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
						</div>
						<span class="col-sm-4" id="redwarning"></span>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputPassword3" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="confirmPassword"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio1" value="男">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="女">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthday">
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="identifycode">

						</div>
						<div class="col-sm-2">
							<img src="${pageContext.request.contextPath}/image/captcha.jhtml" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" 
								style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/jsp/footer.jsp"></jsp:include>

<script type="text/javascript">
$(document).ready(function() {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: '用户名未验证',
                validators: {
                    notEmpty: {
                        message: '用户名必填并且不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '用户名的字符长度必须在6到30之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名只能由字母、数字、点和下划线组成 '
                    }
                }
            },
             name: {
                message: '姓名未验证',
                validators: {
                    notEmpty: {
                        message: '姓名必填并且不能为空'
                    },
                    stringLength: {
                        max: 16,
                        message: '用户名的字符长度不得超过16'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.\u4e00-\u9fa5]+$/,
                        message: '用户名只能由字母、数字、点、汉字和下划线组成 '
                    }
                }
            },
            /* country: {
                validators: {
                    notEmpty: {
                        message: 'The country is required and can\'t be empty'
                    }
                }
            },
            acceptTerms: {
                validators: {
                    notEmpty: {
                        message: 'You have to accept the terms and policies'
                    }
                }
            }, */
            email: {
                validators: {
                    notEmpty: {
                        message: '电子邮箱必填并且不能为空'
                    },
                    emailAddress: {
                        message: '电子邮箱地址不合理'
                    }
                }
            },
         /*    website: {
                validators: {
                    uri: {
                        message: 'The input is not a valid URL'
                    }
                }
            }, */
/*             phoneNumber: {
                validators: {
                    digits: {
                        message: '该值只能包含数字 '
                    }
                }
            },
            color: {
                validators: {
                    hexColor: {
                        message: 'The input is not a valid hex color'
                    }
                }
            },
            zipCode: {
                validators: {
                    zipCode: {
                        country: 'US',
                        message: 'The input is not a valid US zip code'
                    }
                }
            }, */
            password: {
                validators: {
                    notEmpty: {
                        message: '密码必填并且不能为空'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: '两次填入的密码并不相同'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: '确认密码必填并且不能为空'
                    },
                    identical: {
                        field: 'password',
                        message: '两次填入的密码并不相同'
                    }
                }
            },
          /*   ages: {
                validators: {
                    lessThan: {
                        value: 100,
                        inclusive: true,
                        message: 'The ages has to be less than 100'
                    },
                    greaterThan: {
                        value: 10,
                        inclusive: false,
                        message: 'The ages has to be greater than or equals to 10'
                    }
                }
            } */
        }
    });
});
</script>
</body>
</html>




