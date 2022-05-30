<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="lifelog">
    <meta name="description" content="하루의 삶, 사진, 취미">
<title>ButterFly</title>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
        integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/style1.css">
    <script>
    $(function() {
        $(".headC").click(function() {
            $(".headB").slideToggle();
        });
    });
</script>
</head>
<body>
<header>
        <div class="container">
            <div class="container-small">
                <a href="index.html" class="headA">ButterFly</a>
                <button type="button" class="headC"><span class="fa fa-bars" title="MENU"></span>
                </button>
            </div>
            <nav class="headB">
                <ul>
                    <li><a href="main.jsp">로그아웃</a></li>
                    <li><a href="location.href='join.do'">회원가입</a></li>
                    <li><a href="">마이페이지</a></li>
                    <li><a href="">글쓰기</a></li>
                </ul>
            </nav>
        </div>
    </header>
<section class="conA">
        <div class="container">
            <img src="images/butterfly.png" alt="">
            <h1>ButterFly</h1>
            <p></p>
            <a href="#">구경하기</a>
        </div>
    </section>
   <section class="conA-1">
       <div class="container" style="padding-top: 30px">
           <h2>오늘의 인기 사진</h2>
       </div>
   </section>
    <section class="conB">
        <div class="container">
            <div class="item item-a" onclick="">
               <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
            <div class="item item-b">
                <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
            <div class="item item-c">
                <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
            <div class="item item-d">
                <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
        </div>
           <div class="container" style="padding-top: 10px; padding-bottom: 40px">
            <div class="item item-e">
                <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
            <div class="item item-f">
                <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
            <div class="item item-g">
                <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
            <div class="item item-h">
                <a href="#"><i class="fas fa-chevron-right" style="font-size:24px"></i></a>
            </div>
        </div>
    </section>
    
<section class="conC" id="log">
        <div class="container">
            <div class="photo"></div>
            <div class="text">
                <h2>금/토/일 3일간 진행하는 특별세일!</h2>
                <p>주말마다 찾아오는 특별한 가격</p>
                <a href="#">구경하기 <i class="fas fa-chevron-right"></i></a>
            </div>

        </div>
    </section>
    
<section class="conD" id="about">
        <div class="container">
            <div class="photo"></div>
            <div class="text">
                <h2>결제 이벤트</h2>
                <p>결제 전 확인 필수!!</p>
                <a href="#">구경하기 <i class="fas fa-chevron-right"></i></a>
            </div>

        </div>
    </section>
    <footer id="contact">
        <div class="container">
            <div class="footA">
                <h2>ButterFly</h2>
                <p>주소: 경기도 고양시 <br>
                <a href="http://ButterFly.net">http://ButterFly.net</a></p>
                <nav class="footD">
                    <ul>
                        <li><a href="" title="twitter"><i class="fab fa-twitter"></i></a></li>
                        <li><a href="" title="facebook"><i class="fab fa-facebook"></i></a></li>
                        <li><a href="" title="google-plus"><i class="fab fa-google-plus"></i></a></li>
                        <li><a href="" title="instagram"><i class="fab fa-instagram"></i></a></li>
                        <li><a href="" title="youtube"><i class="fab fa-youtube"></i></a></li>
                    </ul>
                </nav>
            </div>
            <nav class="footB">
                <div>
                    <h3>ABOUT</h3>
                    <ul>
                        <li><a href="#">설립</a></li>
                        <li><a href="#">주소</a></li>
                        <li><a href="#">지도</a></li>
                        <li><a href="#">스태프</a></li>
                    </ul>
                </div>
                <div>
                    <h3>SUPPORT</h3>
                    <ul>
                        <li><a href="#">다운로드</a></li>
                        <li><a href="#">주소</a></li>
                        <li><a href="#">자주 묻는 질문</a></li>
                        <li><a href="#">문의</a></li>
                    </ul>
                </div>
                <div>
                    <h3>CONTENTS</h3>
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">주소</a></li>
                        <li><a href="#">프로필</a></li>
                        <li><a href="#">스태프</a></li>
                        <li><a href="#">블로그</a></li>
                    </ul>
                </div>
            </nav>
            <div class="footC">
                &copy; ButterFly corp. All rights Reserved.
            </div>
        </div>
    </footer>

</body>
</html>