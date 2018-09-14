<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manager</title>

</head>
<body>
	<header>
		<h1 class="title vcenter">M A N A G E R</h1>
	</header>
	<hr>
	<nav>
		<div class="navigation vcenter" >
			<a href="${pageContext.request.contextPath }/register">회원등록</a>
			<a href="${pageContext.request.contextPath }/list">회원목록조회/수정</a>
			<a href="${pageContext.request.contextPath }/">홈으로.</a>
		</div>
	</nav>
	<hr>