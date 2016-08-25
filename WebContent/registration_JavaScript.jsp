<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<!DOCTYPE HTML>
<html>

<head>
<title>stationery shop</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
<style>
#error {
	color: red;
}
</style>
</head>
<body>
	<div id="main">
		<header>
			<div id="logo">
				<h1>STATIONERY_SHOP</h1>
			</div>
			<nav>
				<ul class="lavaLampWithImage" id="lava_menu">
					<li><a href="index.html">home</a></li>
					<li class="current"><a href="registration_JavaScript.html">registration
							JavaScript</a></li>
				</ul>
			</nav>
		</header>
		<div id="site_content">
			<div id="sidebar_container">
				<div class="gallery">
					<ul class="images">
						<li class="show"><img width="450" height="450"
							src="images/1.jpeg" alt="photo_one" /></li>
						<li><img width="450" height="450" src="images/2.jpg"
							alt="photo_two" /></li>
						<li><img width="450" height="450" src="images/3.jpg"
							alt="photo_three" /></li>
						<li><img width="450" height="450" src="images/4.jpg"
							alt="photo_four" /></li>
						<li><img width="450" height="450" src="images/5.jpg"
							alt="photo_five" /></li>
					</ul>
				</div>
			</div>
			<div id="content">

				<h1>Registration</h1>
				<form id="registration" name="user_form" method="post"
					action="/Task_9/registration">
					<div class="form_settings">

						<p>
							<span>Name</span><input class="contact" name="user_name"
								value="${user_name}" type="text">
						</p>
						<p>
							<span>Surname</span><input class="contact" name="surname"
								value="${surname}" type="text">
						</p>
						<p>
							<span>Email Address</span><input class="contact" name="email"
								value="${email}" type="text">
						</p>
						<p>
							<span>Password</span><input class="contact" name="pas"
								value="${pas}" type="password">
						</p>
						<p>
							<span>Repeat password</span><input class="contact" name="r_pas"
								value="${r_pas}" type="password">
						</p>
						<p>
							<span>send email</span><input type="checkbox" name="isSend"
								value="SendEmail" ${isSend}>
						</p>
						<p>
							<t:captcha/>
							<input type="hidden" name="userID">
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" id="send"
								name="contact_submitted" value="send" type="submit">
						</p>

					</div>
				</form>
				<div id="error">${error}</div>
			</div>
			<footer>
				<p>
					2016 stationery shop. All Rights Reserved. | <a
						href="http://www.css3templates.co.uk">design from
						css3templates.co.uk</a>
				</p>
			</footer>
		</div>
	</div>
	<!-- javascript validation 
  <script type="text/javascript" src="js/validationJS.js"></script> -->
	<!-- javascript at the bottom for fast page loading -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easing.min.js"></script>
	<script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
	<script type="text/javascript" src="js/image_fade.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#lava_menu").lavaLamp({
				fx : "backout",
				speed : 700
			});
		});
	</script>
</body>
</html>