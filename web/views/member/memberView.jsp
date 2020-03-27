<%@page import="dept.model.vo.DepartmentVO"%>
<%@page import="member.model.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<DepartmentVO> list = (ArrayList<DepartmentVO>)request.getAttribute("list");
	MemberVO vo = (MemberVO)request.getAttribute("vo");
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
	$("#BtnMod").click(function(){
		document.form.action="member?menu=update";
		document.form.submit();
	});
	
	$("#BtnDel").click(function(){
		document.form.action="member?menu=delete";
		document.form.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<section class="goodswrite">
	<div class="content">
		<form method="POST" name="form">
		<input type="hidden" id="member_no" name="member_no" value="<%=vo.getMemberNo()%>">
		<div class="top clearfix">
			<div class="title">
				<h1>사원 관리</h1>
			</div>
			<div class="btn-box clearfix">
				<button id="BtnMod" type="submit" class="del">수정</button>
				<button id="BtnDel" type="submit" class="del">삭제</button>
			</div>
		</div>			
		<div class="col-2">
			<div class="col-2-top clearfix">
				<ul class="clearfix">
					<li class="btn active" data-type="kor">사원 정보</li>
				</ul>					
			</div>
			<div class="write_form kor active">
				<label for="">부서</label><select id="dept_no" name="dept_no">
					<% for(int i = 0; i < list.size(); i++){ %>
           			<option value="<%= list.get(i).getDeptNo() %>" <%if(list.get(i).getDeptNo()==vo.getDeptNo()){%>selected<%}%>><%= list.get(i).getDeptName() %></option>
					<% } %>
				</select>
				<label for="">사원명</label><input type="text" name="member_name" id="member_name" placeholder = "입력해주세요" value="<%=vo.getMemberName()%>"/><br />
			</div>
		</div>
		
		</form>
	</div>
</section>
</body>
</html>