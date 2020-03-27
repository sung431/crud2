<%@page import="java.awt.print.Printable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MemberVO> list = (ArrayList)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>

<!-- CSS -->
<link rel="stylesheet" href="css/list.css" />
<link rel="stylesheet" href="css/menu.css" />

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#memberAdd").click(function(){
		location.href="member?menu=add";
	});
});

function goView(memberNo){
	location.href="member?menu=view&member_no="+memberNo;
}
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<section class="goodslist">
	<div class="content">
		<div class="top clearfix">
			<div class="title">
				<h1>사원 관리</h1>					
			</div>				
			<button id="memberAdd" type="button" class="upload">사원등록</button>
		</div>			
		<div class="col-1">
			<div class="col-1-top clearfix">
				<p class="title">사원 목록</p>		
			</div>
			<table class="col-1-table">
				<colgroup>
					<col width="20%"/>
					<col width="40%"/>
					<col width="40%"/>
				</colgroup> 
				<tr class="title">
					<th>No.</th>
					<th>사원명</th>
					<th>부서명</th>
				</tr>
					<% if(list.size() > 0){ %>
					<% for(int i = 0; i < list.size(); i++){ %>
                    <tr class="data" onclick="javascript: goView(<%= list.get(i).getMemberNo() %>)">
                        <td><%= list.get(i).getMemberNo() %></td>
                        <td><%= list.get(i).getMemberName() %></td>
                        <td><%= list.get(i).getDeptName() %></td>
                    </tr>
                    <% } %>
					<% }else{ %>
	                <tr>
	                    <td colspan="3">조회된 결과가 없습니다.</td>
	                </tr>
					<% } %>
			</table>
		</div>
	</div>
</section>
</body>
</html>