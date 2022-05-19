<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
</head>
<body>
	<div class="container-sm">
		<h1>도서 목록</h1>
		<div>
			<table border="1" class="table table-striped">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
				
					<c:if test="${list.size() < 1 }">
						<tr>
							<td colspan="5">등록된 도서가 없습니다.</td>
						</tr>
					</c:if>
					
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.bookid }</td>
							<td>${item.bookname }</td>
							<td>${item.publisher }</td>
							<td>${item.price }</td>
							<td><a href="update/${item.bookid }" class="btn btn-warning  btn-sm">변경</a> <a href="delete/${item.bookid }" class="btn btn-danger  btn-sm">삭제</a></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		<div>
			<a href="add" class="btn btn-primary">등록</a>
		</div>
	</div>
</body>
</html>