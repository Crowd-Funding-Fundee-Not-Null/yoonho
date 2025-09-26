<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp1 = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Fundee </title>

	<!-- Basic -->
	<!-- Mobile Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<!-- Site Metas -->
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<link rel="shortcut icon" href="<%=cp1 %>/resources/images/favicon.png" type="">



	<!-- bootstrap core css -->
	<link rel="stylesheet" type="text/css" href="<%=cp1 %>/resources/css/bootstrap.css" />

	<!--owl slider stylesheet -->
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
	
	<!-- nice select  -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
	
	<!-- font awesome style -->
	<link href="<%=cp1 %>/resources/css/font-awesome.min.css" rel="stylesheet" />

	<!-- Custom styles for this template -->
	<link href="<%=cp1 %>/resources/css/style.css" rel="stylesheet" />
	
	<!-- responsive style -->
	<link href="<%=cp1 %>/resources/css/responsive.css" rel="stylesheet" />



<style>

body {
	font-family: 'AppleSDGothicNeo', Pretendard-Regular, sans-serif;
}

.custom_nav-container .navbar-nav .nav-item .nav-link {
	color: black;
}

</style>




</head>
<body>
    
    <header class="header_section">
    
	<div class="container">
		<nav class="navbar navbar-expand-lg custom_nav-container ">
		<a class="navbar-brand" href="index.do">
			<span style="color:black !important;">
				Fundee
			</span>
		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class=""> </span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav  mx-auto "  style="padding-left: 0; margin-left:20px !important;">
				<li class="nav-item ${active eq 'home' ? 'active' : ''}">
					<a class="nav-link" href="index.do">Home</a>
				</li>
				<li class="nav-item ${active eq 'posts' ? 'active' : ''}">
					<a class="nav-link" href="posts_list.do">펀딩하기</a>
				</li>
				<li class="nav-item ${active eq 'notice' ? 'active' : ''}">
					<a class="nav-link" href="notice.do">공지사항</a>
				</li>
				<li class="nav-item ${active eq 'qna' ? 'active' : ''}">
					<a class="nav-link" href="qna.do">고객센터</a>
				</li>
			</ul>
			
			<div class="user_option">
				<a href="" class="user_link">
					<i class="fa fa-user" aria-hidden="true"></i>
				</a>
				<a class="cart_link" href="#">
				</a>
				
				<form class="form-inline">
					<button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
						<i class="fa fa-search"></i>
					</button>
				</form>
              
              
				<c:choose>
				<c:when test="${not empty sessionScope.loginId}">
					<!-- 로그인 상태: 로그아웃 버튼 -->
					<a href="${pageContext.request.contextPath}/logout" class="order_online">logout</a>
					
					<!-- 닉네임(없으면 ID로 대체) -->
					<span style="margin-left:10px; color:black;">
						<c:choose>
						<c:when test="${not empty sessionScope.loginNickname}">
							${fn:escapeXml(sessionScope.loginNickname)}님
						</c:when>
						<c:otherwise>
							${fn:escapeXml(sessionScope.loginId)}님
						</c:otherwise>
						</c:choose>
					</span>
				</c:when>
					
				<c:otherwise>
					<!-- 비로그인 상태: 로그인/회원가입 -->
					<a href="${pageContext.request.contextPath}/loginForm.do" class="order_online">login</a>
					<a href="${pageContext.request.contextPath}/join.do" class="order_online">join</a>
				</c:otherwise>
				</c:choose>
              
              
			</div>
		</div>
		</nav>
	</div>
	
	</header>
    

</body>
</html>