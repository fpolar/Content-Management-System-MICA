<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MICA Projects</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/MICA.css">
<link rel="stylesheet" type="text/css" href="css/projects.css">
<link rel="stylesheet" type="text/css" href="slick/slick.css" />
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css" />
<link rel="stylesheet" type="text/css"
	href="css/slick_modifications.css">
<link
	href="https://fonts.googleapis.com/css?family=Comfortaa:300,400,700|Josefin+Sans:300,300i,400,400i,700,700i|Lobster|Pacifico|Sansita:400,400i,700,900"
	rel="stylesheet">

</head>
<body>
	<div id="header">
		<img src="imgs/SailLogo.png" class="logo">

		<div id="mica">
			<a href="home.jsp">MICA</a>
		</div>

		<div class="menu">
			<a href="home.jsp#people">People</a> <a
				href="projects.jsp">Projects</a> <a
				href="http://sail.usc.edu/aigaion2/index.php/topics/single/13">Publications</a>
		</div>
	</div>
	<div id="page_title">
		<h1>Current Projects</h1>
	</div>
	<ul>
		<c:forEach items="${projects}" var="project">
			<li>
				<div class="proj_text">
					<div class="proj_title">
						<a href="project.jsp?projectName=${project.getTitle() }">${project.getTitle() }</a>
					</div>
					<div class="proj_desc">${project.getDescription() }</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>