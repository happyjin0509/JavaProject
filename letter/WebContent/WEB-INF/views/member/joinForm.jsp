<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lnag="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
        integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet"
	href="${conPath }/css/joinForm.css">
</head>
<body>
	<form action="join.do" method="post">
			
			<!-- header -->
        <div id="header">
            <a href="join.do" target="_blank" title="회원가입 페이지 보러가기">
            <img src="${conPath }/images/logo.jpg" id="logo"></a>
        </div>


        <!-- wrapper -->
        <div id="wrapper">

            <!-- content-->
            <div id="content">
            
			<!-- 아이디 -->
			<div>
				<h3 class="join_title">
					<label for="id">아이디</label>
				</h3>
				<span class="box int_id"> <input type="text" id="id" name="id"
					class="int" maxlength="20" value="${param.id}">
				</span> <span class="error_next_box"></span>
				<c:if test="${errors.id}">ID를 입력하세요.</c:if>
				<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
			</div>
			
	
			<!-- 비번1 -->
			<div>
				<h3 class="join_title">
					<label for="pswd1">비밀번호</label>
				</h3>
				<span class="box int_pass"> <input type="password" id="pswd1" name="password"
					class="int" maxlength="20"> <span id="alertTxt">사용불가</span>
					<i id="pswd1_img1" class="fa fa-lock pswdImg" style="font-size:24px; color: #dadada"></i>
				</span> <span class="error_next_box"></span>
				<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
			</div>

			<!-- 비번2 -->
			<div>
				<h3 class="join_title">
					<label for="pswd2">비밀번호 재확인</label>
				</h3>
				<span class="box int_pass_check"> <input type="password" name="confirmPassword"
					id="pswd2" class="int" maxlength="20"> 
					<i id="pswd2_img1" class="fa fa-check-circle pswdImg" style="font-size:24px; color: #dadada"></i>
				</span> <span class="error_next_box"></span>
				<c:if test="${errors.confirmPassword}">확인을 위해 비밀번호를 한 번 더 입력해주세요.</c:if>
				<c:if test="${errors.notMatch}">일치하지 않습니다.</c:if>
			</div>


			<!-- 이름 -->
			<div>
				<h3 class="join_title">
					<label for="name">이름</label>
				</h3>
				<span class="box int_name"> <input type="text" id="name" name="name"
					class="int" maxlength="20">
				</span> <span class="error_next_box"></span>
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
			</div>

			
			<!-- 생년월일  -->
			<div>
				 <h3><label for="yy">생년월일</label></h3>
				<input class="box" type="date" max="2010-01-01" name="birthday">
			</div>
			
			<!-- 이메일  -->
			 <div>
                    <h3 class="join_title"><label for="email">본인확인 이메일<span class="optional">(선택)</span></label></h3>
                    <span class="box int_email">
                        <input type="text" id="email" name="email" class="int" maxlength="100" placeholder="선택입력">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>
               
                 <!-- 가입 버튼-->
                <div class="btn_area">
                    <input class="sub" id="btnJoin" type="submit" value="가입하기">
                </div>

		
		</div>
            <!-- content-->

        </div> 
        <!-- wrapper -->
	</form>
</body>
</html>