<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	Cookie[] ck = request.getCookies();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
   
   
     
<style>


/* From Uiverse.io by KSAplay */ 
.likey-container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

.likey-container {
  display: block;
  position: absolute;
  right: 50px;
  bottom: 0px;
  cursor: pointer;
  font-size: 20px;
  user-select: none;
  transition: 100ms;
}

.checkmark {
  top: 0;
  left: 0;
  height: 2em;
  width: 2em;
  transition: 100ms;
  animation: dislike_effect 400ms ease;
}

.likey-container input:checked ~ .checkmark path {
  fill: #FF5353;
  stroke-width: 0;
}

.likey-container input:checked ~ .checkmark {
  animation: like_effect 400ms ease;
}

.likey-container:hover {
  transform: scale(1.1);
}

@keyframes like_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}

@keyframes dislike_effect {
  0% {
    transform: scale(0);
  }

  50% {
    transform: scale(1.2);
  }

  100% {
    transform: scale(1);
  }
}



</style>

   
   
   


<script type="text/javascript">



</script>





</head>
<body>


<div class="hero_area">
  
	<!-- header section starts -->
	
	<%@ include file="header.jsp" %>
	
    <!-- end header section -->
    
    
    
	<!-- 캐러셀 슬라이드 section -->
	<div class="slider_section ">
		<div id="customCarousel1" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
			
			
				<div class="carousel-item active">
					<div class="container ">
						<div class="row carousel-img carousel-img1" >
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">
                  	
									<h1>
                    
									</h1>
									<div class="carousel-img-explain">
										<h3>대체당 싹 빼고</h3>
										<h3>녹차애사비 원물로만 90% 채웠어요</h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="carousel-item ">
					<div class="container ">
						<div class="row carousel-img carousel-img2">
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">
									<h1>
                      
									</h1>
									<div class="carousel-img-explain">
										<h3>이거 마시면 피부 하얘져요</h3>
										<h3>5세대 먹는 레티놀</h3>
									</div>
                    
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="carousel-item">
					<div class="container ">
						<div class="row carousel-img carousel-img3">
							<div class="col-md-7 col-lg-6 ">
 								<div class="detail-box">
									<h1>
                      
									</h1>
                    
									<div class="carousel-img-explain">
 										<h3>200만원대 명품 스웨이드</h3>
										<h3>2주만 20만원대</h3>
									</div>
                    
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
        
	        
			<a class="carousel-control-prev" href="#customCarousel1" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#customCarousel1" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
	  
	  		
	        
			<div class="container">
				<ol class="carousel-indicators">
					<li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
					<li data-target="#customCarousel1" data-slide-to="1"></li>
					<li data-target="#customCarousel1" data-slide-to="2"></li>
				</ol>
			</div>
		</div>
	
	</div>
	<!-- end slider section -->
    
    
    
    
    
    
    
	<section class="offer_section layout_padding-bottom">
		<div class="container ">
			<div>
				<p class="main-rcm-intro">
					지금, 참여해야 할 추천 펀딩
			</p>
		</div>
		    
		<div class="row">
			<div class="col-md-6">
				<div class="box main-rcm-box">
					<div class="detail-box">
						<img src="https://ohmycompany.imgix.net/uploads/reward/img/2025/09/2121714119/REWARD_2db024a4eaf4.jpg?lossless=1&h=450"
							class="main-rcm-img"/>
					</div>
					<div class="detail-box-right">
						<div class="detail-box-top">
							<span class="main-rcm-percent">83%</span> 
							<span class="main-rcm-amount">1,142,800원</span><br/>
						</div>
	                
						<div class="detail-box-price">
							<span class="main-rcm-price">15,000원~</span>
						</div>
		                
						<div class="detail-box-subject">
							<span class="main-rcm-subject">[열매탐정인증] 산지직송 프리미엄 안심 샤인머스켓</span><br/>
						</div>
		              	
						<div class="detail-box-seller">
							<span class="main-rcm-seller">펀디농장</span><br/>
						</div>
		              	
						<div class="detail-box-bottom">
							<i class="fa fa-star" style="color: #ffca1a;"></i>
							<span class="main-rcm-rate">4.8</span> 
							<span class="main-rcm-ratecount">(324)</span>
						</div>
		                
					</div>
				</div>
			</div>
	          
	          
			<div class="col-md-6  ">
				<div class="box main-rcm-box">
					<div class="detail-box">
						<img src="https://ohmycompany.imgix.net/uploads/reward/img/2022/09/13046/REWARD_20221026103727537.jpg?lossless=1&h=450"
							class="main-rcm-img"/>
					</div>
					<div class="detail-box-right">
						<div class="detail-box-top">
							<span class="main-rcm-percent">145%</span> 
							<span class="main-rcm-amount">7,257,000원</span><br/>
						</div>
	                
						<div class="detail-box-price">
							<span class="main-rcm-price">
								50,000원~
							</span>
						</div>
	                
						<div class="detail-box-subject">
							<span class="main-rcm-subject">실내정원용 업사이클링 화분대</span><br/>
						</div>
	              	
						<div class="detail-box-seller">
							<span class="main-rcm-seller">열린사회</span><br/>
						</div>
	              	
						<div class="detail-box-bottom">
							<i class="fa fa-star" style="color: #ffca1a;"></i>
							<span class="main-rcm-rate">4.4</span> 
							<span class="main-rcm-ratecount">(109)</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
    
      
    
    
    
</div>



<!-- 랜덤 4개 띄우기 -->
	
<section class="offer_section layout_padding-bottom">
<div class="container ">
			
	<div style="width: 100%;">
		<div style="display: inline-block;">
			<p class="main-random-intro">
				실시간 급상승 펀딩
			</p>
		</div>
			    
		<div id="refreshBtn" class="refreshBtn">
			<i class="fa fa-refresh" style="color: #444444;"></i> 새로고침
		</div>
	</div>
		    
	<div style="width:100%; margin-left: 15px; justify-content: space-between;" id="random-container">
	</div>
	
</div>
</section>


 


<!-- footer section -->

<%@ include file="footer.jsp" %>

<!-- footer section -->



<script>

//새로고침 버튼 눌렀을 때 loadLists 함수를 실행
document.getElementById("refreshBtn").addEventListener("click", loadLists);

function loadLists() {
    fetch("getShuffledLists", {
        method: "GET",
        headers: { 
            "Accept": "application/json"   // JSON으로 응답받겠다는 의미
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("HTTP error! status: " + response.status);
        }
        return response.json();
    })
    .then(data => {
        const container = document.getElementById("random-container");
        container.innerHTML = "";
        
        //getShuffledLists로 받아온 Lists의 각 dto에 대해 다음을 실행
        data.forEach(dto => {
        	//새로운 div를 eachdiv라는 DOM으로 만든 뒤 style부여
            const eachdiv = document.createElement("div");
            eachdiv.style.width = "25%";
            eachdiv.style.height = "340px";
            eachdiv.style.display = "inline-block";
            eachdiv.style.verticalAlign = "top";
            
            //inner.HTML에서 사용할 변수들 미리 설정
            const cp = "<%=cp %>";
            const wishlist = getWishlist();
            var ch = '';
            var code = dto.title.substr(0,5)+'_'+dto.posts_num;
            if (wishlist.includes(code)) {
				ch += 'checked';
         	}
            
            const current_amount_formatted = new Intl.NumberFormat('ko-KR').format(dto.current_amount);
            const percentage_formatted = Math.round(((dto.current_amount / dto.goal_amount) * 100));
            const price_formatted = new Intl.NumberFormat('ko-KR').format(dto.price);
            const img_location = dto.image_file.substr(19);
            const temp_title = dto.title.substr(0,5);
            
            
            eachdiv.innerHTML = `
            
            	<div style='position: relative;'>
            	
            		<img src="`+cp+`/resources/images/`+ img_location +`" class="main-rcm-img"  
            			onclick="openProductDetail(`+dto.posts_num+`)"/>
            		
            		<label class="likey-container" >
            			<input type="checkbox" id="myCheckbox_`+dto.posts_num +`" name="myCheckbox" 
            				onclick="handleCheckboxCookie(this);" value="`+temp_title+`_`+dto.posts_num+`" `+ch+`/>
            				
            			<div class="checkmark">
            				<svg viewBox="0 0 290 290">
            				<rect fill="none" height="256" width="256"></rect>
            				<path d="M224.6,51.9a59.5,59.5,0,0,0-43-19.9,60.5,60.5,0,0,0-44,17.6L128,59.1l-7.5-7.4C97.2,28.3,59.2,26.3,35.9,47.4a59.9,59.9,0,0,0-2.3,87l83.1,83.1a15.9,15.9,0,0,0,22.6,0l81-81C243.7,113.2,245.6,75.2,224.6,51.9Z" stroke-width="17px" stroke="#ffffff" fill="#a9a9a9"></path></svg>
            			</div>
            			
            		</label>
            		
            	</div>
            	
            	<div>
            		<span class="main-rcm-percent">
            			`+percentage_formatted+`%
            		</span> 
            		<span class="main-rcm-amount">
            			`+current_amount_formatted+`원
            		</span><br/>
            	</div>
            	
            	<div class="detail-box-price">
            		<span class="main-rcm-price">`+ price_formatted +`원~</span>
            	</div>
            	
            	<div class="detail-box-subject">
            		<span class="main-rcm-subject">`+ dto.title +`</span><br/>
            	</div>
            	
            	<div class="detail-box-seller">
            		<span class="main-rcm-seller">`+ dto.userId +`</span><br/>
            	</div>
            	
            	<div class="detail-box-bottom">
            		<i class="fa fa-star" style="color: #ffca1a;"></i>
            		<span class="main-rcm-rate">4.8</span> 
            		<span class="main-rcm-ratecount">(324)</span>
            	</div>`;
            	
            container.appendChild(eachdiv);
        });
    })
    .then(clearInterval(timer)) //새로고침 시간 초기화
    .then(timer = setInterval(loadLists, 5000)) //현재 시점부터 다시 카운트 시작
    .catch(err => console.error("Fetch error:", err));
    
}

//일정 시간마다 loadLists 자동 호출
var timer = setInterval(loadLists, 5000);

//페이지가 로드될 때 한 번 실행
window.onload = loadLists();



function openProductDetail(posts_num) {
	location.href = 'article.do?posts_num='+posts_num;
}





</script>








<script>

//찜 목록에 해당 item 추가
function addWish(itemId) {
	let wishlist = getWishlist();
	if (!wishlist.includes(itemId)) {
		wishlist.push(itemId);
		setWishlist(wishlist);
	}
}

//찜 목록에서 해당 item 삭제
function removeWish(itemId) {
	let wishlist = getWishlist().filter(id => id !== itemId);
	setWishlist(wishlist);
}

//찜하기 버튼 클릭시 checked를 기준으로 추가 또는 삭제
function handleCheckboxCookie(checkbox) {
    const itemId = checkbox.value;
    if (checkbox.checked) {
    	addWish(itemId);
    } else {
    	removeWish(itemId);
    }
}

//찜 목록을 쿠키에서 불러오기
function getWishlist() {
	const cookie = document.cookie
		.split("; ")
		.find(row => row.startsWith("wishlist="));
  
	return cookie ? JSON.parse(decodeURIComponent(cookie.split("=")[1])) : [];
}

//찜 목록을 쿠키에 올리기
function setWishlist(list) {
	document.cookie = "wishlist=" + encodeURIComponent(JSON.stringify(list)) + "; path=/";
}

//찜 목록에 해당 item이 올라가있다면 checked 속성 부여
function applyWishlistToCheckboxes() {
	const wishlist = getWishlist();
	document.querySelectorAll('input[type="checkbox"][name="myCheckbox"]').forEach(cb => {
		if (wishlist.includes(cb.value)) {
			cb.setAttribute("checked", "checked")
		}
	});
}



</script>


<style>

body {
	font-family: 'AppleSDGothicNeo', Pretendard-Regular, sans-serif;
}


.custom_nav-container .navbar-nav .nav-item .nav-link {
	color: black;
}


.hero_area {
	flex: none;
	min-height: 0;
}


.slider_section {
	margin: 0 auto;
	width: 900px;
	display: block;
	flex: none;
	padding-bottom: 20px;
}


.carousel-inner {
	border-radius: 10px;
}


.carousel-img {
	width: 900px;
	height: 304px;
	background-size: contain;
	border-radius: 10px;
}

.carousel-img1 {
	background: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, .4)),
	url("https://cdn.wadiz.kr/ft/images/live-adm01/2025/0909/20250909093059458_7746.jpg/wadiz/resize/900/format/jpg/quality/85/");
}

.carousel-img2 {
	background: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, .4)),
	url("https://cdn.wadiz.kr/ft/images/live-adm02/2025/0916/20250916165816865_7746.jpg/wadiz/resize/900/format/jpg/quality/85/");
	
}

.carousel-img3 {
	background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, .4)),
	url("https://cdn.wadiz.kr/ft/images/live-adm01/2025/0916/20250916164542769_7746.png/wadiz/resize/900/format/jpg/quality/85/");
}


.carousel-img-explain {
	width: 600px !important;
	margin-top: 200px;
	margin-left: 20px;
	vertical-align: bottom;
}


.slider_section .carousel-indicators li {
	border: 1px solid #ffbe33;
}

.carousel-indicators {
	margin-top: 10px !important;
}

.carousel-control-prev {
	margin-top: 165px;
	height: 50px;
}
.carousel-control-next {
	margin-top: 165px;
	height: 50px;
}


.main-rcm-intro {
	font-size: 21px;
	font-weight: 600;
	margin-bottom: 0;
	margin-left: 15px;
}

.main-rcm-box {
	margin-top: 10px !important;
	
}


.offer_section {
	padding-bottom: 45px;
}

.offer_section .box {
	background-color: #ffffff;
}


.main-rcm-img {
	width: 240px; 
	height: 180px;
	border-radius: 10px;
	object-fit: cover;
	margin-right: 17px;
}


.detail-box-left {
	color: black;
}
.detail-box-right {
	height: 180px;
	color: black;
}


.main-rcm-percent {
	color: #ff6666; 
	font-weight: 500; 
	font-size:17pt;
}
.main-rcm-amount {
	color: #212529; 
	font-weight: 300; 
	font-size:12pt;
}
.main-rcm-price {
	color: #27caa1; 
	font-weight: 500; 
	font-size:17pt;
	
}
.main-rcm-subject {
	color: #212529;
	
}
.main-rcm-seller {
	color: gray;
}
.main-rcm-rate {
	color: #212529;
}
.main-rcm-ratecount {
	font-size:10pt; color: gray;
}


.detail-box-top {
	
}
.detail-box-price {
	margin-bottom: 3px;
}
.detail-box-subject {
	width: 250px !important;
}
.detail-box-seller {
	position: absolute;
	bottom: 25px;
}
.detail-box-bottom {
	position: absolute;
	bottom: 0px;
}



.main-random-intro {
	font-size: 21px;
	font-weight: 600;
	margin-bottom: 30px;
	margin-left: 15px;
}


.refreshBtn {
	display: inline-block;
	border: 1px darkgray solid;
	border-radius: 5px;
	cursor: pointer;
	float: right;
	margin-right: 30px;
	vertical-align: middle;
	padding: 7px 9px 7px 9px;
	color: #212529; 
	font-size: 15px;
	box-shadow: 0 0 3px;
}

.main-rcm-img {
	position: relative;
	cursor: pointer;
}




</style>


</body>

</html>