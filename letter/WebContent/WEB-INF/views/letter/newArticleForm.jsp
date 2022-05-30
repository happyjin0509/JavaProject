<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<c:set var="conPath"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 쓰기</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css" integrity="sha384-zIaWifL2YFF1qaDiAo0JFgsmasocJ/rqu7LKYH8CoBEXqGbb9eO+Xi3s6fQhgFWM" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   function readURL(input) {
      if (input.files && input.files[0]) {
	      var reader = new FileReader();
	      reader.onload = function (e) {
	    	  console.log(e.target);
	        $('#preview').attr('src', e.target.result);
          }
         reader.readAsDataURL(input.files[0]);
      }
  } 
 </script>  
</head>
<body>

<form action="${conPath }/article/write.do" method="post" enctype="multipart/form-data"></form>
<div style="margin-left: 400px">
<h2> 게시글 작성 </h2>
</div>
<div class="container">    
<form action="/insertProc" method="post">      
<div class="form-group">
<label for="subject">제목</label>        
<input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요.">   
</div>

<!-- <p>
	제목:<br/><input type="text" name="title" >
	
</p> -->

<div class="form-group">        
<label for="writer">닉네임</label>        
<input type="text" class="form-control" id="writer" name="writer" placeholder="내용을 입력하세요.">      
</div>


<!-- <p>
	닉네임:<br/><input type="text" name="nickname" >
	
</p> -->

<div class="form-group">     
<label for="content">내용</label>        
<textarea class="form-control" id="content" name="content" rows="3"></textarea>
</div>

<!-- <p>
	내용:<br/>
	<textarea name="content" rows="5" cols="30"></textarea>
</p> -->

<p>
<input type="file" name="imageFileName"  onchange="readURL(this);" />
<img  id="preview" src="#"   width=200 height=200/>
	
</p>

<!-- <input type="submit" value="새 글 등록"> -->
 <button type="submit" class="btn btn-warning">작성</button>

</form>
</div>
</body>
</html>