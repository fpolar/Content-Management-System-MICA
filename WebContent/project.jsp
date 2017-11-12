<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MICA Project</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/MICA.css">
<link rel="stylesheet" type="text/css" href="css/project.css">
<link rel="stylesheet" type="text/css"
	href="/MICA/css/project_pages/auto_cont_analysis.css">
<link rel="stylesheet" type="text/css" href="slick/slick.css" />
<link rel="stylesheet" type="text/css"
	href="slick/slick-theme.css" />
<link rel="stylesheet" type="text/css"
	href="css/slick_modifications.css">
<link
	href="https://fonts.googleapis.com/css?family=Comfortaa:300,400,700|Josefin+Sans:300,300i,400,400i,700,700i|Lobster|Pacifico|Sansita:400,400i,700,900"
	rel="stylesheet">
</head>
<body>
	<div id="header">
		<img src="../imgs/SailLogo.png" class="logo">

		<div id="mica">
			<a href="home.jsp">MICA</a>
		</div>
		<div class="menu">
			<a href="home.jsp#people">People</a> <a href="projects.jsp">Projects</a>
			<a href="http://sail.usc.edu/aigaion2/index.php/topics/single/13">Publications</a>
		</div>
	</div><br>
	<c:forEach items="${projects}" var="project">
	<br>
		<c:if test="${project.getTitle().equals(param['projectName'])}">
			<div id="page_title">
				<h1>${project.getTitle()}</h1>
			</div>
			<div id="desc">${project.getDescription()}</div>

			<c:if test="${project.getInstructions().size()>0}">
				<div id="instructions">
					<ul>
						<c:forEach items="${project.getInstructions()}" var="instruction">
							<li>${instruction}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>

			<c:if test="${project.getDemos().size()>0}">
				<div id="demos">
					<ul>
						<c:forEach items="${project.getDemos()}" var="demo">
							<li id="demo-${demo.getTitle() }">${demo.printHTML()}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
		</c:if>
	</c:forEach>
	<div id="footer">
		<div id="twitter">
			<a href="https://twitter.com/SAIL_USC" class="twitter-follow-button"
				data-size="large" data-show-count="false">Follow @SAIL_USC</a>
			<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
		</div>

	</div>
</body>
</html>