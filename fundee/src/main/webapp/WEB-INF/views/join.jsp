<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("UTF-8");
    String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>

  <!-- 공용 CSS -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/responsive.css" />

  <!-- 페이지 전용 스타일 -->
  <style>
    .heading_container {
      display: flex;
      justify-content: center;
      align-items: center;
      margin: 32px 0 24px;
    }
    #joinPage .form_container {
      max-width: 640px;
      margin: 0 auto;
      border: 1px solid #ddd;
      border-radius: 12px;
      padding: 28px;
      background: #fff;
      box-shadow: 0 6px 20px rgba(0,0,0,.08);
    }
    #joinPage .field { margin-bottom: 16px; }
    #joinPage label {
      display:block; font-weight:600; margin-bottom:8px;
    }
    #joinPage .form-control { height:46px; font-size:16px; }
    #joinPage .role-group {
      display:flex; gap:16px; align-items:center; flex-wrap:wrap;
    }
    #joinPage .role-group label {
      display:inline-flex; align-items:center; gap:6px; font-weight:500; margin:0;
    }
    #joinPage .btn_box button {
      width:100%; height:48px; border:0; border-radius:10px;
      background:#ffd400; font-weight:700; letter-spacing:.2px;
      transition: transform .05s ease, box-shadow .2s ease, background .2s ease;
    }
    #joinPage .btn_box button:hover {
      background:#ffcf00; box-shadow:0 6px 16px rgba(0,0,0,.08); transform:translateY(-1px);
    }
    #joinPage .links { text-align:center; margin-top:18px; }
    #joinPage .links a { margin:0 8px; text-decoration:none; }
  </style>
  
  
  

  <script>
async function validateForm(e){
  e.preventDefault();
  const form   = document.getElementById('joinForm');
  const pw     = (document.getElementById('password')?.value || '').trim();
  const pw2    = (document.getElementById('passwordCheck')?.value || '').trim();
  const email  = (document.getElementById('email')?.value || '').trim();
  const nickname = (document.getElementById('nickName')?.value || '').trim();

  // 비밀번호 체크
  if(!pw || !pw2){ alert("비밀번호를 입력하세요."); return false; }
  if(pw !== pw2){  alert("비밀번호가 일치하지 않습니다."); return false; }

  // 이메일 입력 체크
  if(!email){ alert("이메일을 입력하세요."); return false; }

  // 닉네임 입력 체크
  if(!nickname){ alert("닉네임을 입력하세요."); return false; }

  // web.xml 패턴에 맞춰 필요시 .do 로 교체
  const emailUrl = '<c:url value="/checkEmail"/>'; 
  const nickUrl  = '<c:url value="/checkNickname"/>'; // ★ 새 매핑 필요

  try {
    // 이메일 중복 검사
    const r1 = await fetch(emailUrl + '?email=' + encodeURIComponent(email), { cache: 'no-store' });
    const raw1 = await r1.text();
    const t1 = (raw1 || '').trim();
    if(!r1.ok) throw new Error('HTTP ' + r1.status + ' ' + t1);
    const emailExists = Number(t1);
    if(emailExists > 0){
      alert('이미 사용 중인 이메일입니다.');
      return false;
    }

    // 닉네임 중복 검사
    const r2 = await fetch(nickUrl + '?nickname=' + encodeURIComponent(nickname), { cache: 'no-store' });
    const raw2 = await r2.text();
    const t2 = (raw2 || '').trim();
    if(!r2.ok) throw new Error('HTTP ' + r2.status + ' ' + t2);
    const nickExists = Number(t2);
    if(nickExists > 0){
      alert('이미 사용 중인 닉네임입니다.');
      return false;
    }

  } catch(err){
    alert('중복 확인 중 오류: ' + err.message);
    return false;
  }

  // 모든 검사 통과 → 제출
  form.submit();
  return false;
}
</script>

  
  
  
  
</head>
<body>
  <section id="joinPage" class="book_section layout_padding">
    <div class="container">

      <!-- 제목 중앙 -->
      <div class="heading_container">
         <a class="navbar-brand" href="index.do">
            <span style="color:#000;">Feane</span>
         </a>
      </div>
		 
      <!-- 가입 폼 박스 -->
      <div class="form_container">
        <!-- 컨트롤러: POST /join -->
        <form id="joinForm"
              method="post" 
              action="${pageContext.request.contextPath}/join"
              onsubmit="return validateForm(event)">
          <div class="field">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" class="form-control" required placeholder="Id">
          </div>

          <div class="field">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" class="form-control" required placeholder="Password">
          </div>

          <div class="field">
            <label for="passwordCheck">비밀번호 확인</label>
            <input type="password" id="passwordCheck" name="passwordCheck" class="form-control" required placeholder="PasswordCheck">
          </div>

          <div class="field">
            <label for="nickName">닉네임</label>
            <input type="text" id="nickName" name="nickname" class="form-control" required placeholder="Nickname">
          </div>

          <div class="field">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" class="form-control" required placeholder="Name">
          </div>

          <div class="field">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" class="form-control" required placeholder="Email">
          </div>

          <div class="field">
            <label for="phone">전화번호</label>
            <input type="text" id="phone" name="phone" class="form-control" required placeholder="Phone">
          </div>

          <div class="field">
            <label for="address">주소</label>
            <input type="text" id="address" name="address" class="form-control" required placeholder="Address">
          </div>

          <div class="field">
            <label>회원유형</label>
            <div class="role-group">
              <label><input type="radio" name="role" value="0" checked="checked"> 일반회원</label>
              <label><input type="radio" name="role" value="1"> 관리자</label>
            </div>
          </div>

          <div class="btn_box">
            <button type="submit">가입하기</button>
          </div>
        </form>

        <div class="links">
          <a href="${pageContext.request.contextPath}/loginForm">로그인</a>
        </div>
      </div>
    </div>
  </section>
</body>
</html>