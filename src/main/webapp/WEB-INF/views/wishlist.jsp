<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>





<head>



<style type="text/css">




.notice_wrapper1 {
	border: 1px solid lightgray;
	width: 84%;
	margin: 100px auto;
	padding: 50px 30px 50px 30px;
	font-size: 11pt;
}

.notice_header_wrapper {
	width: 94%;
	margin: 0 auto;
	margin-bottom: 30px;
	
}

.notice_header_left {
	display: inline-block;
}

.cookie_delete_button {
	float: right;
	margin: auto;
	padding-top: 8px;
	text-align: center;
	width : 100px;
	height: 40px;
	border: 1px solid lightgray;
	border-radius: 7px;
	background: rgb(248,249,250);
	margin-top: 130px;
	margin-right: 20px;
	vertical-align: top !important;
}

.cookie_delete_button:hover {
	background: rgb(238,238,238);
	cursor: pointer;
}


.notice_subheader {
	color: #787878;
}


.notice_list_wrapper2 {
	border: 1px solid lightgray;
	border-radius: 5px;
	width: 94%;
	margin: 15px auto;
	padding: 20px 15px 20px 15px;
	background: rgb(248,249,250);
	font-weight: 500;
}

.notice_list_wrapper2:hover {
	background: rgb(238,238,238);
	cursor: pointer;
}

.important_notice_alert {
	color: white;
	font-size: 8pt;
	border-radius: 20%;
	display: inline-block;
	background: midnightblue;
	margin-right: 3px;
	padding: 2px 3px 2px 3px;
}

.notice_title_wrapper {
	display: inline-block;
	vertical-align: middle;
}

.notice_regdate_wrapper {
	display: inline-block;
	vertical-align: middle;
	float: right;
}

.paging_wrapper1 {
	text-align: center;
	margin: 0 auto;
	margin-top: 30px;
	font-size: 15pt;
}


.page-link {
	color: black !important;
}

.active .page-link {
	color: #ffffff !important;
}










.main-wishlist-box {
	margin-top: 10px !important;
	width: 100% !important;
	height: 200px;
}


.offer_section {
	padding-bottom: 45px;
}

.offer_section .box {
	background-color: #ffffff;
}


.main-wishlist-img {
	width: 240px; 
	height: 180px;
	border-radius: 10px;
	object-fit: cover;
	margin-right: 17px;
	vertical-align: bottom;
	cursor: pointer;
}


.detail-box-left {
	color: black;
}
.detail-box-right {
	height: 180px;
	color: black;
	display: inline-block;
	vertical-align: bottom;
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
	
}
.detail-box-seller {
	margin-top: 35px;
}
.detail-box-bottom {
}












</style>



<script type="text/javascript">

function openProductDetail(posts_num) {
	location.href = 'article.do?posts_num='+posts_num;
}




</script>





</head>


<body class="sub_page">

  <!-- header section start -->
  
  <%@ include file="header.jsp" %>
  
  <!-- header section end -->


  <!-- book section -->
  
    
    <div class="notice_wrapper1">
    	<div class="notice_header_wrapper">
    	
    		<div class="notice_header_left">
	    		<div class="notice_header">
		    		<h1>Wish List</h1>
		    	</div>
		    	<div class="notice_subheader">
		    		<font style="color: darkred;">♥</font> 찜한 상품을 확인하세요.
		    	</div>
    		</div>
    		
    	</div>
    	
    	<div class="notice_list_wrapper1">
    	
    	
    		<!-- 
    	
    		<c:forEach var="dto" items="${lists }">
    			<div class="notice_list_wrapper2" 
    				onclick="javascript:location.href='article.do?posts_num=${dto.posts_num}';">
    				<div style="display: inline-block; width: 200px; height: 200px;">
    					<img src="<%=cp%>/resources/images/${dto.image_file}"
    						style="width: 100%;">
    				</div>
    				<div class="notice_title_wrapper">
    					${dto.title }
    				</div>
    				<div class="notice_regdate_wrapper">
    					${dto.posts_num }
    				</div>
    			</div>
    		</c:forEach>
    		
    		 -->
    	
    		<c:forEach var="dto" items="${lists }">
    		<div style="margin-left: 30px;">
	            <div class="box main-wishlist-box">
	              <div class="detail-box-right">
	                <img src="<%=cp%>/resources/images/${dto.image_file}" class="main-wishlist-img"
	                	onclick="openProductDetail(${dto.posts_num})"/>
	              </div>
	              <div class="detail-box-right">
	              	<div class="detail-box-top">
		              	<span class="main-rcm-percent">
		              		<fmt:formatNumber type="number" pattern="###,###,###,###,###,###"
		              		value="${(dto.current_amount / dto.goal_amount) * 100}"/>%
		              	</span> 
		                <span class="main-rcm-amount">
		                	<fmt:formatNumber value="${dto.current_amount}"/>원
		                </span><br/>
	              	</div>
	                
	                <div class="detail-box-price">
	                	<span class="main-rcm-price">
	                		<fmt:formatNumber value="${dto.price}"/>원~
	                	</span>
	                </div>
	                
	                <div class="detail-box-subject">
	                	<span class="main-rcm-subject">${dto.title }</span><br/>
	              	</div>
	              	
	                <div class="detail-box-seller">
	                	<span class="main-rcm-seller">${dto.userId }</span><br/>
	              	</div>
	              	
	              	<div class="detail-box-bottom">
	                	<i class="fa fa-star" style="color: #ffca1a;"></i>
	                <span class="main-rcm-rate">4.8</span> 
	                <span class="main-rcm-ratecount">(324)</span>
	              </div>
	                
	              </div>
	              
	              <div class="cookie_delete_button" onclick="deleteCookie('${dto.title }',${dto.posts_num })">
		   			삭제
		    	</div>
	              
	              
	            </div>
	          </div>
    		</c:forEach>
    	
    		
    	
    	</div>
    	
    	<br/>
    	
    	
    </div>
    
    
    
  </section>
  <!-- end book section -->

<script type="text/javascript">

function deleteCookie(title,num) {
	
	const itemId = title.substr(0,5) + '_' + num;
	
	let wishlist = getWishlist().filter(id => id !== itemId);
	setWishlist(wishlist);
	  
	location.href = '';
}


function getWishlist() {
	
	const cookie = document.cookie
		.split("; ")
		.find(row => row.startsWith("wishlist="));
	  
	return cookie ? JSON.parse(decodeURIComponent(cookie.split("=")[1])) : [];
}
	
	
function setWishlist(list) {
	
	document.cookie = "wishlist=" + encodeURIComponent(JSON.stringify(list)) + "; path=/";
}	
	
	
</script>

  <!-- footer section start -->

  <%@ include file="footer.jsp" %>

  <!-- footer section end -->

</body>
</html>