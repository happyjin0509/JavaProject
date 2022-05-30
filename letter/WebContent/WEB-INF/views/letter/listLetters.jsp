<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
<h1>게시판 목록 보기</h1>
 <table class="table table-hover">
    <thead>
	
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자 닉네임</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:if test="${articlePage.hasNoArticles()}">
	 
	<tr>
		<td colspan="4">게시글이 없습니다.</td>
	</tr>
	</c:if>
	</thead>
	 <tbody>
	<c:forEach var="article" items="${articlePage.content}" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>
		<a href="read.do?no=${article.letter_id}&pageNo=${articlePage.currentPage}">
		<c:out value="${article.title}"/>
		</a>
		</td>
		<td>${article.nickname}</td>
		<td>${article.regdate}</td>
		<td>${article.readCount}</td>
	</tr>
</c:forEach>
   </tbody>


<c:if test="${articlePage.hasArticles()}">
	<tr>
		<td colspan="5">
			<c:if test="${articlePage.startPage > 5}">
			<a href="list.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${articlePage.startPage}" 
					   end="${articlePage.endPage}">
			<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
			</c:forEach>
			<c:if test="${articlePage.endPage < articlePage.totalPages}">
			<a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
			</c:if>
		</td>
	</tr>
</c:if>	

</table>

<button type="button" class="btn btn-outline-primary"><a href="${conPath }/article/write.do">글쓰기</a></button>

</body>
</html>