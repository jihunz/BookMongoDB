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
	<div class="container-sm mb-12">
		<h1>도서 등록</h1>
		<form method="post">
			<div class="input-group mb-2">
				<label class="input-group-text">도서명 : </label>
				<input type="text" class="form-control" name="bookname" placeholder="도서명 입력하세요">
			</div>
			<div class="input-group mb-2">
				<label class="input-group-text">출판사 : </label>
				<input type="text" class="form-control" name="publisher" placeholder="출판사를 입력하세요">
			</div>
			<div class="input-group mb-2">
				<label class="input-group-text">가격 : </label>
				<input type="number" class="form-control" name="price" placeholder="가격을 입력하세요">
			</div>
			<div>
				<button class="btn btn-primary">등록</button>
				<a href="./list"  class="btn btn-dark">이전</a>
			</div>
		</form>
	</div>
</body>
</html>