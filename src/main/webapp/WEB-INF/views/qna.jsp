<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	margin: 40px auto;
	
}

.notice_header_left {
	display: inline-block;
}

.notice_write_button {
	float: right;
	margin: auto;
	padding-top: 8px;
	text-align: center;
	width : 100px;
	height: 40px;
	border: 1px solid lightgray;
	border-radius: 7px;
	background: rgb(248,249,250);
	margin-top: 12px;
	vertical-align: middle;
}

.notice_write_button:hover {
	background: rgb(238,238,238);
	cursor: pointer;
}


.notice_subheader {
	color: #787878;
}



.question_answered {
	color: white;
	width: 60px;
	height: 23px;
	font-size: 9pt;
	border-radius: 10px;
	display: inline-block;
	background: midnightblue;
	margin-left: 10px;
	padding: 2px 3px 2px 3px;
	text-indent: 5px;
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







.question-table-title {
	height: 52px;
	background-color: rgb(245,245,245);
}


.question-row {
	height: 45px;
}

.question-row:hover {
	background-color: rgb(238,238,238);
}


.question-row-title {
	color: #212529;
}

.question-row-title:hover {
	color: #007bff;
}



</style>









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
		    		<h2>Q & A</h2>
		    	</div>
		    	<div class="notice_subheader">
		    		문의사항 및 불편한 점이 있다면 자유롭게 알려주세요.
		    	</div>
    		</div>
   			<div class="notice_write_button"
   				onclick="javascript:location.href='question_write.do?pageNum=${currentPage}';">
   				글쓰기
    		</div>
    		
    		
    	</div>
    	
    	<div class="notice_list_wrapper1">
    	
    		<table style="width: 94%; margin: 0 auto;">
    		
    			<tr><td colspan="4" height="4" style="background-color: lightgray;"></tr>
    		
    			<tr class="question-table-title">
    				<td style="width: 5%; text-align: center;">No</td>
    				<td style="text-align: center;">제목</td>
    				<td style="width: 13%; text-align: center;">작성자</td>
    				<td style="width: 13%; text-align: center;">작성일</td>
    			</tr>
    			
    			
    			<c:forEach var="dto" items="${lists }">
    			
    			<tr><td colspan="4" height="1" style="background-color: #eeeeee;"></tr>
    			
    			<tr class="question-row">
    				<td style="text-align: center;">${dto.board_num}</td>
    				<td style="text-indent: 30px;">
    					<c:if test="${dto.secret==1 }">🔒 &nbsp;</c:if>
    					<a href="qna_detail.do?question_num=${dto.question_num }&pageNum=${currentPage }" class="question-row-title">
    						${dto.title }
    					</a>
    					<c:if test="${dto.answered }">
    						<div class="question_answered">답변완료</div>
    					</c:if>
    				</td>
    				<td style="text-align: center;">${dto.name }</td>
    				<td style="text-align: center;">${dto.reg_date }</td>
    			</tr>
    			</c:forEach>
    		
    			<tr><td colspan="4" height="1" style="background-color: #eeeeee;"></tr>
    		
    		</table>
    	
    	
    	
    	
    		
    	
    	</div>
    	
    	<br/>
    	
    	<div class="paging_wrapper1">
   			<c:if test="${dataCount!=0 }">
				${pageIndexList }
			</c:if>
			<c:if test="${dataCount==0 }">
				등록된 게시물이 없습니다. 
			</c:if>
    	</div>
    	
    </div>
    
    
    
  </section>
  <!-- end book section -->



  <!-- footer section start -->

  <%@ include file="footer.jsp" %>

  <!-- footer section end -->

</body>
</html>