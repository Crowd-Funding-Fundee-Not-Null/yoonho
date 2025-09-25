<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp2 = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


  


<style type="text/css">


.footer_section {
	background-color: #f8f9fa;
	color : black;
	height: 320px; 
	padding: 40px 0 40px 0;
}

.footer-wrapper-div {
	width: 67%; 
	margin: 0 auto; 
	text-align: left; 
	font-size: 10pt; 
	color: #212529;
	display: inline-block;
}

.footer-menu {
	margin-bottom: 10px;
}

.footer-menu-a {
	color: #212529;
}

.footer-menu-a:hover {
	color: #007bff;
}

.footer-logo-div {
	margin: 10px 50px 10px 0; 
	display: inline-block !important;
}

.footer-logo {
	color:#007bff !important;
}

.footer_social {
	display: inline-block !important; 
	width: 300px;
}

.footer-social-icon {
	display: inline-block !important;
}

.footer-info1 {
	margin-bottom: 10px;
}

.footer-info2 {
	margin-bottom: 10px;
	color: #949494;
}

.footer-logo-img-div {
	width: 20%; 
	display: inline-block; 
	vertical-align: top;
}

.footer-logo-img {
	 width:90%;
}

.moveTopBtn-img {
	width: 40px; 
	height: 40px;
	position: fixed; 
	right: 40px; 
	bottom: 40px; 
	background-color: transparent; 
	border-radius: 50%;
	cursor: pointer;
}

.likeyListBtn-img {
	width: 40px; 
	height: 40px;
	position: fixed; 
	right: 40px; 
	bottom: 90px; 
	background-color: transparent; 
	border-radius: 50%;
	cursor: pointer;
}







</style>





</head>
<body>







<!-- footer section -->
<footer class="footer_section">
	<div class="footer-wrapper-div">
        <div class="footer-menu">
     		<a class="footer-menu-a" href="index.do">홈으로</a> &nbsp;| &nbsp;
     		<a class="footer-menu-a" href="notice.do">공지사항</a> &nbsp;| &nbsp; 
     		<a class="footer-menu-a" href="#">회사소개</a>&nbsp; |&nbsp; 
     		<a class="footer-menu-a" href="qna.do">고객센터</a>
     	</div>
     	
     	<div>
    	    <div class="footer-logo-div">
	    		<a href="index.do" class="footer-logo"><h2>Fundee</h2></a>
	    	</div>
	    	<div class="footer_social">
				<a href="" class="footer-social-icon">
	                <i class="fa fa-facebook" aria-hidden="true"></i>
	            </a>
	            <a href="" class="footer-social-icon">
	                <i class="fa fa-twitter" aria-hidden="true"></i>
	             </a>
	             <a href="" class="footer-social-icon">
	                <i class="fa fa-instagram" aria-hidden="true"></i>
	             </a>
	         </div>
     	</div>

    	<div class="footer-info1">
    		<span>
    			Fundee &nbsp;&nbsp;|&nbsp;&nbsp; 
    			대표자 : 박지원, 강혜정, 장소영, 김윤호 &nbsp;&nbsp;|&nbsp;&nbsp; 
    			경기 수원시 팔달구 중부대로 104 풍림빌딩신관 4층 &nbsp;&nbsp;|&nbsp;&nbsp; 
    			이메일 : fundee@notnull.kr
    		</span>
    	</div>
    	<div class="footer-info2">
	    	<span>
	    		Fundee는 중개업(온라인소액투자중개 및 통신판매중개)을 영위하는 플랫폼 제공자로 자금을 모집하는
				당사자가 아닙니다. 따라서 투자손실의 위험을 보전하거나 상품 제공을 보장해 드리지 않으며 이에 대한 법적인
				책임을 지지 않습니다. 상품, 상품정보, 거래에 관한 의무와 책임은 판매자에게 있으므로, 각 상품 페이지에서 구체적인 내용을 확인하시기 바랍니다.
	    	</span>
	    </div>
	    <div class="footer-info3">
    		<span>
    			© 2025. Fundee. All rights reserved.
    		</span>
    	</div>	
	</div>
	<div class="footer-logo-img-div">
		<img src="<%=cp2 %>/resources/images/fundee-logo.png" class="footer-logo-img"/>
	</div>
</footer>
<!-- footer section -->

<!-- jQery -->
<script src="<%=cp2 %>/resources/js/jquery-3.4.1.min.js"></script>
<!-- popper js -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
</script>
<!-- bootstrap js -->
<script src="<%=cp2 %>/resources/js/bootstrap.js"></script>
<!-- owl slider -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
</script>
<!-- isotope js -->
<script src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
<!-- nice select -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
<!-- custom js -->
<script src="<%=cp2 %>/resources/js/custom.js"></script>
<!-- Google Map -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
</script>
<!-- End Google Map -->


<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>



<a class="moveTopBtn">
	<img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2Fs6jL5%2FbtqHsbU8DSJ%2FAAAAAAAAAAAAAAAAAAAAAGo-OShZXiIcpoKwvPTHjv727n_eLNJ4JWcIMKe7gAnW%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1759244399%26allow_ip%3D%26allow_referer%3D%26signature%3Df8DIZGNIXiZcGZeEiIFEZfhy3PM%253D" class="moveTopBtn-img">
</a>
<a class="likeyListBtn">
	<img src="data:image/png;base64,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" 
		class="likeyListBtn-img" onclick="wishlist()">
</a>


<script type="text/javascript">

const moveTopBtn = document.querySelector(".moveTopBtn");

moveTopBtn.onclick = () => {
	window.scrollTo({
		top: 0, behavior: "smooth"
	});
}


function wishlist() {
	
	location.href = 'wishlist.do';
	
}


</script>







</body>
</html>