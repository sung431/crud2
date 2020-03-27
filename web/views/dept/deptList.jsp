<%@page import="dept.model.vo.DepartmentVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<DepartmentVO> list = (ArrayList<DepartmentVO>)request.getAttribute("list");
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
	$("#deptAdd").click(function(){
		location.href="dept?menu=add";
	});
});

function goView(deptNo){
	location.href="dept?menu=view&dept_no="+deptNo;
}
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<section class="goodslist">
	<div class="content">
		<div class="top clearfix">
			<div class="title">
				<h1>부서 관리</h1>					
			</div>				
			<button id="deptAdd" type="button" class="upload">부서추가</button>
		</div>			
		<div class="col-1">
			<div class="col-1-top clearfix">
				<p class="title">부서 목록</p>		
			</div>
			<table class="col-1-table">
				<colgroup>
					<col width="40%"/>
					<col width="60%"/>
				</colgroup> 
				<tr class="title">
					<th>No.</th>
					<th>부서명</th>
				</tr>
					<% if(list.size() > 0){ %>
					<% for(int i = 0; i < list.size(); i++){ %>
                    <tr class="data" onclick="javascript: goView(<%= list.get(i).getDeptNo() %>)">
                        <td><%= list.get(i).getDeptNo() %></td>
                        <td><%= list.get(i).getDeptName() %></td>
                    </tr>
                    <% } %>
					<% }else{ %>
	                <tr>
	                    <td colspan="2">조회된 결과가 없습니다.</td>
	                </tr>
	                <% } %>
			</table>
		</div>
	</div>
</section>
</body>
</html>