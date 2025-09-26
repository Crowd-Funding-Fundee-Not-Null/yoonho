<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	int role = (Integer)request.getAttribute("role");
	int isAuthorized = (Integer)request.getAttribute("isAuthorized");
	
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

.notice_subheader {
	color: #787878;
}


.notice_detail_title_wrapper {
	width: 94%;
	margin: 15px auto;
	font-weight: 500;
	font-size: 17pt;
}

.notice_detail_content_wrapper {
	width: 94%;
	margin: 0 auto;
	margin-bottom: 50px;
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

.notice_line {
	width: 94%;
	margin-top: 20px;
	margin-bottom: 15px;
}

.notice_detail_info_wrapper {
	width: 97%;
	text-align: right;
	font-size: 10pt;
}

.answer_write_button, .answer_delete_button {
	float: right;
	font-size: 11pt;
	font-weight: normal;
	color: #0c0c0c;
	margin: auto;
	padding-top: 8px;
	text-align: center;
	width : 100px;
	height: 40px;
	border: 1px solid lightgray;
	border-radius: 7px;
	background: rgb(248,249,250);
	vertical-align: middle;
}





.notice_return_button,.notice_delete_button {
	display: inline-block;
	margin: auto;
	margin-top: 30px;
	margin-left: 4px;
	margin-right: 4px;
	padding-top: 8px;
	text-align: center;
	width : 100px;
	height: 40px;
	border: 1px solid lightgray;
	border-radius: 7px;
	background: rgb(248,249,250);
}

.notice_return_button:hover, .answer_write_button:hover, .answer_delete_button:hover {
	background: rgb(238,238,238);
	cursor: pointer;
}

.notice_write_button_wrapper {
	margin: 0 auto;
	width: 240px;
}


.swal2-title {
	font-style: none !important;
}


</style>



<% if (role==1 || isAuthorized==1) { %>
<style>
.notice_delete_button:hover {
	background: rgb(238,238,238);
	cursor: pointer;
}
</style>
<% } %>





<script type="text/javascript">

function deleteQuestion(question_num,pageNum) {
	
	Swal.fire({
		  text: "정말 삭제하시겠습니까?",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "삭제하기",
		  cancelButtonText: "취소"
		}).then((result) => {
		  if (result.isConfirmed) {
			  Swal.fire({
		        text: "정상적으로 삭제되었습니다.",
		        icon: "success"
		      }).then((result) => {
		    		  location.href="question_delete.do?question_num="+question_num+"&pageNum="+pageNum;	  
		      });
			  
		  }
		});
	
	
}


function deleteAnswer(answer_num,question_num,pageNum) {
	
	Swal.fire({
		  text: "정말 답변을 삭제하시겠습니까?",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "삭제하기",
		  cancelButtonText: "취소"
		}).then((result) => {
		  if (result.isConfirmed) {
			  Swal.fire({
		        text: "답변이 정상적으로 삭제되었습니다.",
		        icon: "success"
		      }).then((result) => {
		    		location.href="answer_delete.do?answer_num="+answer_num+"&question_num="+question_num+"&pageNum="+pageNum;
		      });
			  
		  }
		});
	
	
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
		    		<h2>Q & A</h2>
		    	</div>
		    	<div class="notice_subheader">
		    		문의사항 및 불편한 점이 있다면 자유롭게 알려주세요.
		    	</div>
		    </div>
	    	
    	</div>
    	
    	<div class="notice_detail_wrapper1">
    	
    		<div class="notice_detail_title_wrapper">
    			${dto.title }
    			
    			
    			<c:if test="${dto.answered==false}">
    			
    			<div class="answer_write_button"
	    			onclick="javascript:location.href='answer_write.do?question_num=${question_num }&pageNum=${pageNum}';">
	    			답변하기
	    		</div>
	    		
	    		</c:if>
	    		
	    		
    		</div>
    		
    		
    		<hr class="notice_line">
    		
    		<div class="notice_detail_info_wrapper">
    			등록일 : ${dto.reg_date }
    		</div>
    		
    		<div class="notice_detail_content_wrapper">
    			${dto.content }
    		</div>
    		
    		<hr class="notice_line">
    		
    		
    		
    		
    		<c:if test="${dto.answered==true}">
    		
    		<div class="notice_detail_title_wrapper">
    			답변내용
    			
    			<c:if test="${role==1 }">
    			<div class="answer_delete_button"
	    			onclick="deleteAnswer(${answerDTO.answer_num },${question_num},${pageNum})">
	    			삭제하기
	    		</div>
	    		</c:if>
    			
    			
    		</div>
    		
    		<hr class="notice_line">
    		
    		<div class="notice_detail_info_wrapper">
    			등록일 : ${answerDTO.reg_date }
    		</div>
    		
    		<div class="notice_detail_content_wrapper">
    			${answerDTO.content }
    		</div>
    		
    		<hr class="notice_line">
    		
    		
    		</c:if>
    		
    		
    		
    		<div class="notice_write_button_wrapper">
	    		<div class="notice_return_button"
	    			onclick="javascript:location.href='qna.do?pageNum=${pageNum}';">
	    			목록으로
	    		</div>
	    		
	    		
	    		
	    		
	    		<div class="notice_delete_button" 
	    			<c:if test="${role!=1 && isAuthorized!=1}">
	    				style="color: gray;"
	    			</c:if>
	    			<c:if test="${role==1 || isAuthorized==1}">
	    				onclick="deleteQuestion(${question_num },${pageNum})"
	    			</c:if>
	    		>
	    			삭제하기
	    		</div>
	    		
	    		
	    		
	    		
	    		
	    		
    		</div>
    		
    		
    	</div>
    	
    	
    </div>
    
    
    
    
  </section>
  <!-- end book section -->

  <!-- footer section start -->

  <%@ include file="footer.jsp" %>

  <!-- footer section end -->

</body>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

</html>