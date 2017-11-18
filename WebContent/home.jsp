<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>MICA</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/MICA.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="slick/slick.css" />
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css" />
<link rel="stylesheet" type="text/css"
	href="css/slick_modifications.css">
<link
	href="https://fonts.googleapis.com/css?family=Comfortaa:300,400,700|Josefin+Sans:300,300i,400,400i,700,700i|Lobster|Pacifico|Sansita:400,400i,700,900"
	rel="stylesheet">
</head>
<body>
	<%@ page import="jsonParser.JsonParser"%>
	<%
		JsonParser.setAttributesFromJson(request, response);
	%>
	<div id="header">
		<img src="imgs/SailLogo.png" class="logo">

		<div class="menu">
			<a href="#people">People</a> <a href="./projects.jsp">Projects</a>
			<a href="http://sail.usc.edu/aigaion2/index.php/topics/single/13">Publications</a>
		<c:forEach items="${pages}" var="page">
			<a href="${page.getLink()}">${page.getTitle()}</a>
		</c:forEach>
		</div>
	</div>
	<div id="page_title">
		<h1>MICA</h1>
		<h2>Media Informatics and Content Analysis</h2>
	</div>
	<div id="home_demos" class="slideshow">
		<c:forEach items="${slides}" var="slide">
			<div class="slide">
				<img src="${slide.getImg()}">
				<div class="demo_text">
					<div class="demo_title">
						<a href="project.jsp?projectName=${slide.getTitle()}">${slide.getTitle()}</a>
					</div>
					<div class="demo_desc">${slide.getDesc()}</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="about">
		<div id="tweets">
			<a class="twitter-timeline" data-theme="light"
				data-link-color="#2384c5" href="https://twitter.com/SAIL_USC">Tweets
				by SAIL_USC</a>
			<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
		</div>
		<h1>About Us</h1>
		<div class="textb">${aboutUs }</div>
	</div>

	<div id="people">
		<ul>
			<c:forEach items="${people}" var="peopleGroup">
				<li>
					<h3>${peopleGroup.getKey()}</h3>
					<ul class="thumbnail">
						<c:forEach items="${peopleGroup.getValue()}" var="person">
							<li>
								<div class="pic">
									<!--<img src="imgs/people/${person.getImg() }">-->
									<img
										src="https://raw.githubusercontent.com/fpolar/sites/master/mica/imgs/people/frank.jpg">
									<div class="infob">
										${person.getName() }<br> <br> ${person.getTitle() }<br>
										<br> ${person.getSchool() }<br> <br>
										${person.getContact() }<br>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>

	<div id="footer">
	<div id="powered-by">
	
	</div>
		<div id="twitter">
			<a href="https://twitter.com/SAIL_USC" class="twitter-follow-button"
				data-size="large" data-show-count="false">Follow @SAIL_USC</a>
			<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script type="text/javascript" src="js/slickInit.js"></script>


</body>
</html>
