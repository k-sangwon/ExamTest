<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="/common/header.jsp"%>
<section>
	<h1>Member List</h1>
	<table border="1px solid black">
<tr>
<th>NAME</th>
<th>ID</th>
<th>PW</th>
<th>JOINDATE</th>
</tr>
<c:forEach items="${list }" var="member">
<tr>
<td>${member.member_name }</td>
<td>${member.member_id }</td>
<td>${member.member_pw }</td>
<td>${member.member_join_date }</td>
<td><a href="${pageContext.request.contextPath}/list?member_id=${member.member_id}">삭제</a></td> 
<tr>
</c:forEach>


</table>
	

</section>

