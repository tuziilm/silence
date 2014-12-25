<%@include file="../include/common.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>后台系统登录</title>
<link rel="icon" type="image/png"
	href="${basePath}static/common/favicon.png" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${basePath}static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${basePath}static/theme/${_theme}/global.css"
	rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

#errors {
	padding-left: 0;
}
</style>
<link
	href="${basePath}static/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<script type="text/javascript">
	function buttonTest() {
		//js = Qd2oBa2AoN615FyEDk+mAbGT5oNSNOpBUBHHrw6n2+\/0HGxT5sqJvrEAhnOZzAJ15PAz83ymHDyixyLW9aSJgy50cSQIct8jRBLdgjjY+jQYFgxWKA0wF1FcPx0FojMaIHyrIE+lrtji7nZU5T5\/wNZwRnAkBc8pJsRzRNKZ8NeM2jnNbitGape5JXpfLicVNi41bO50UvGsyNuDf2Wz85veZcgM+3xE4cXzenJ0+C0YGzn1a5Zj73e\/Yoka+dA0HVFmsGht5yaSHYv0MIcSF5iJc2vsbTxMmcmGPLIAOtKIo8cQE4TWsR5ESVOqc+UJH3WutlDOoXQmnqJIcePzT9m2jEzwEgP7UJrPEfNOVXh+uVmiQbByUAyiBpiaHRWX6AjSviKafR4RsDKJZHLDzvvUFZ7AmyGMUQEmK2aFvSWn5HDhJiYev5fKUyU2LmHYkLMojwr4HHw=
		//jsupload = Qd2oBa2AoN615FyEDk+mAbGT5oNSNOpBUBHHrw6n2+\/0HGxT5sqJvrEAhnOZzAJ15PAz83ymHDyixyLW9aSJgy50cSQIct8jRBLdgjjY+jQYFgxWKA0wF1FcPx0FojMaIHyrIE+lrtji7nZU5T5\/wNZwRnAkBc8pJsRzRNKZ8NeM2jnNbitGakpViFbU1quqm\/agewotIaaBnVfYY400LDSlJKzEAXR3SY+EMUvqD5Um8ReR++l9YqYMZMY7jcbQkxLiVM78OsUmFT3MT97JOM9vLcP5RBGfguNKhUIbDYG69CtLL3iTjohDifVTzjhEm1U6EnFfsvDm6hwr4aXHY7ie9PBwiYw1flPjjzU51llMlJqZkn+NMLbCZc0CLwLyQzPSNHZfxDiYhcBr+Iq2Qg9AMI8wT1yoqjaJq8+eV6LhYFZQ3HJehJ+roaxP7jgqJk9Y91zTH\/Jj+kpELU\/k5TXUOhv3GMKVyorxLV+cMjiW8TAfaTe7DxZOJBKf+3OEzwPt58rOanvE1X8o8rfT5a6hEAwbdkQAwIFQhnkVCfTTVbSgvkgbDHsYyaLGcs6zh5elBw5BVIzGJimFT5Qd2R3k0LbCL7PYfs+nfZwD\/wC\/Y\/I+QiLZF5LKkwF5I6cYXzQfJJQtPJDuNX6P2g2C4f9VQCQMhk8UhGnFrR0iaDW3iOR9EJkddg==
		//rs = Qd2oBa2AoN615FyEDk+mAbGT5oNSNOpBa0c1dFnh\/cpclbGFiFNOEnnuQNQDdryl2Jjt+cPfcfNtPibidtBYc7V19Lr+uCdTw9uZRN2Mf1SLoTRN2QkOJu7GaJEPCrTYPyHk1ToSd9pzbnKvEBy8kguw+rX9tnN9u7HsA4Ba4DQFXkuITidmOjwPz3x\/xtncIIUGojbFuwQaAziw4vuJwRC+KD5d9Gzk76lCUWQR431WYK1+PYdpUwbWap2mdQstRIRMqVnrAbTR0oLXD4SDNN9W+fSGybh0GVGT8Lcq6vy7rSPKr54WIYzbokyOwvbxePCIARGpXrfjmQoqT7JQUvv5\/oEOM\/H6qougBvTGHDhnDKlkMTGs\/gpyES\/zFPieDXnfFyjsOfdP8A2jPQ1ftmIVRcJn+H+9x9Msghaa9S0ApeXmNSMsqA==
		//app = ygRSuGO+8Zatoynz6oRAU6HftVv+wLXdV0nKcOtDQmxgmeSrzOSeoV8TJMS0zZnQ2JerP9l93wOR4\\/BfXuLWjgfmryGgN+vmH7o64pMXoLM=
		//pop = Qd2oBa2AoN615FyEDk+mAbGT5oNSNOpB7+OBIjzY3L5MEwYdCDkUh2npCVy8tqL6raiSVtAiqLNbYzg9EQcne4PakGgFcg7nHRKZrLqKAJw3umfibAPgPK7mcLHr5vASzldqyfvTPUSXX4JkYeF9l6oYt\/eyyOg\/TkWkibGtE3j9Qu0cefx0SbO4PQZ96OlivoELvKCEvxkD\/8Al0cu+oEGbEN9bDe1gne+rCB+JyyXGjnOWgqjBOuPBSuDWgJ9Kxa4WCbivyAExJwPbtvOcsw==
		//ygRSuGO+8ZY\\/tUyeJWidpnXB0mgqJe4tgCVgPCsN+KgoyjTTg6fGBLyMVZpoWmxgK1LxIueXeTuwr8ueFlJ3ScvS0BK+09soFg+J+QgNMF7M\\/Ltlgn7A0u6CCEhn7+sld2y1vcuAb1\\/M9iYCITxrvQ==
		var data = {
			"data" : "Qd2oBa2AoN615FyEDk+mAbGT5oNSNOpBUBHHrw6n2+\/0HGxT5sqJvrEAhnOZzAJ15PAz83ymHDyixyLW9aSJgy50cSQIct8jRBLdgjjY+jQYFgxWKA0wF1FcPx0FojMaIHyrIE+lrtji7nZU5T5\/wNZwRnAkBc8pJsRzRNKZ8NeM2jnNbitGape5JXpfLicVNi41bO50UvGsyNuDf2Wz85veZcgM+3xE4cXzenJ0+C0YGzn1a5Zj73e\/Yoka+dA0HVFmsGht5yaSHYv0MIcSF5iJc2vsbTxMmcmGPLIAOtKIo8cQE4TWsR5ESVOqc+UJH3WutlDOoXQmnqJIcePzT9m2jEzwEgP7UJrPEfNOVXh+uVmiQbByUAyiBpiaHRWX6AjSviKafR4RsDKJZHLDzvvUFZ7AmyGMUQEmK2aFvSWn5HDhJiYev5fKUyU2LmHYkLMojwr4HHw="
			
			//js//"data" : "Qd2oBa2AoN615FyEDk+mAbGT5oNSNOpBUBHHrw6n2+\/0HGxT5sqJvrEAhnOZzAJ15PAz83ymHDyixyLW9aSJgy50cSQIct8jRBLdgjjY+jQYFgxWKA0wF1FcPx0FojMaIHyrIE+lrtji7nZU5T5\/wNZwRnAkBc8pJsRzRNKZ8NeM2jnNbitGakpViFbU1quqm\/agewotIaaBnVfYY400LDSlJKzEAXR3SY+EMUvqD5Um8ReR++l9YqYMZMY7jcbQkxLiVM78OsUmFT3MT97JOM9vLcP5RBGfguNKhUIbDYG69CtLL3iTjohDifVTzjhEm1U6EnFfsvDm6hwr4aXHY7ie9PBwiYw1flPjjzU51llMlJqZkn+NMLbCZc0CLwLyQzPSNHZfxDiYhcBr+Iq2Qg9AMI8wT1yoqjaJq8+eV6LhYFZQ3HJehJ+roaxP7jgqJk9Y91zTH\/Jj+kpELU\/k5TXUOhv3GMKVyorxLV+cMjiW8TAfaTe7DxZOJBKf+3OEzwPt58rOanvE1X8o8rfT5a6hEAwbdkQAwIFQhnkVCfTTVbSgvkgbDHsYyaLGcs6zh5elBw5BVIzGJimFT5Qd2R3k0LbCL7PYfs+nfZwD\/wC\/Y\/I+QiLZF5LKkwF5I6cYXzQfJJQtPJDuNX6P2g2C4f9VQCQMhk8UhGnFrR0iaDW3iOR9EJkddg=="
		};
		alert("dddddddddddddddddddddd");
		$.ajax({
			type : "POST",
			//contentType : 'application/json',
			//url: "/updateBrowerInfos",
			//url: "${basePath}rs/registerinfo",
			url : "${basePath}jm/uploaddata",
			//url: "${ctx}/downloadurl",
			data : data,
			dataType : 'json',
			success : function(data) {
				alert(data);
			}
		});
	}
</script>
</head>

<body>

	<div class="container">

		<form id="login_form" onsubmit="return checkLogin();"
			class="form-signin" action="${basePath}login" method="post">
			<h2 class="form-signin-heading">请登录</h2>
			<div id="errors"></div>
			<label for="username">用户名:</label> <input name="username" type="text"
				class="input-block-level" placeholder="用户名"> <label
				for="passwd">密码:</label> <input name="passwd" type="password"
				class="input-block-level" placeholder="密码">
			<button class="btn btn-large btn-primary" type="submit">登录</button>
			

		</form>
		<input type="button" name="button" value="TEST"
				onclick="buttonTest()">
		<form action="${basePath}jm/uploaddata" method="post">
			<input type="submit" value="ajax test">
		</form>

	</div>
	<!-- /container -->
	<script type="text/javascript"
		src="${basePath}static/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript"
		src="${basePath}static/theme/${_theme}/global.js"></script>
</body>
</html>