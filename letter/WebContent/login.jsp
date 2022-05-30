<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Internet letter - login</title>
<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/style.css">
<!-- <script type="text/javascript" src="script/member.js"></script> -->
</head>
<body>
	<div class="outwrap">
		<div class="inwrap" style="margin-top: 100px">
			<div class="form">
				<form action="login.do" method="post" name="frm">
					<table class="img-table">
					<img src="images/butterfly.jpg" width="250px">
					<tr></tr>
					<tr>
						<td id="label"><label for="id">ID</label></td>
					</tr>
					<tr>
						<td><input type="text" name="id" id="id" class="id_pw" >
						</td>
					</tr>
					<tr>
						<td id="label"><label for="password">P/W</label>
						</td>
					</tr>
					<tr>
						<td><input type="password" id="password" name="password" class="id_pw" >
						</td>
					</tr>
					<c:if test="${empty authUser}">
					<tr>
						<td id="loginA"><input type="submit"value="로그인" onclick="location.href='login.do'" class="loginA buttonA"  ></td>
					</tr>
					
					</c:if>
					<%-- <tr>
						<td colspan="2">${message}</td>
					</tr> --%>
				</table>
				</form>			
			</div>
			
		  </figcaption>
		  <a href="#"></a>
		</figure>
	
		</div>
		</div>
	</div>
</body>
</html>