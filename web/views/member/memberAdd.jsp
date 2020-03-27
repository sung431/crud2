<%@page import="dept.model.vo.DepartmentVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<DepartmentVO> list = (ArrayList)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>

<!-- CSS -->
<link rel="stylesheet" href="css/add.css" />
<link rel="stylesheet" href="css/menu.css" />

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#BtnAdd").click(function(){
		document.form.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<section class="goodswrite">
	<div class="content">
		<form action="member?menu=insert" method="POST" name="form">
		
		<div class="top clearfix">
			<div class="title">
				<h1>사원 관리</h1>
			</div>
			<div class="btn-box clearfix">
				<button id="BtnAdd" type="submit" class="save">등록</button>
			</div>
		</div>			
		<div class="col-2">
			<div class="col-2-top clearfix">
				<ul class="clearfix">
					<li class="btn active" data-type="kor">사원 등록</li>
				</ul>					
			</div>
			<div class="write_form kor active">
				<label for="">부서</label><select id="dept_no" name="dept_no">
					<% for(int i = 0; i < list.size(); i++){ %>
			    	<option value="<%= list.get(i).getDeptNo() %>"><%= list.get(i).getDeptName() %></option>
			    	<% } %>
				</select>
				<label for="">사원명</label><input type="text" name="member_name" id="member_name" placeholder = "입력해주세요"/><br />
			</div>
		</div>
		
		</form>
	</div>
</section>
</body>
</html>