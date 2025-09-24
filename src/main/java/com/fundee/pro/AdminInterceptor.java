package com.fundee.pro;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fundee.dao.LoginDAO;
import com.fundee.util.AlertUtil;

public class AdminInterceptor implements HandlerInterceptor {

	/* 주의사항!!
	 * 구글 크롬에서는 캐시 기능때문에 alert 창이 제대로 뜨지 않는 경우가 있음
	 * 해결법 :
	 * 1. 개발자툴(F12) 열었을 때만 캐시 비활성화하기 (https://hyoni-k.tistory.com/33 참고)
	 * 2. url을 ip 대신 localhost로 사용
	 * 3. Edge 브라우저로 실행
	 * 
	 */
	
	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		//String path = request.getContextPath();
		
		String loginId = (String)session.getAttribute("loginId");
		
		if (loginId==null || loginId.equals("")) {
			AlertUtil.alertAndBackPage(response, "로그인 후 이용해주세요.");
	        return false;
		}
		
		int role = loginDAO.findRoleById(loginId);
		
		if (role==0) {
			AlertUtil.alertAndBackPage(response, "접근 권한이 없습니다.");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}
