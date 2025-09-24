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

	/* ���ǻ���!!
	 * ���� ũ�ҿ����� ĳ�� ��ɶ����� alert â�� ����� ���� �ʴ� ��찡 ����
	 * �ذ�� :
	 * 1. ��������(F12) ������ ���� ĳ�� ��Ȱ��ȭ�ϱ� (https://hyoni-k.tistory.com/33 ����)
	 * 2. url�� ip ��� localhost�� ���
	 * 3. Edge �������� ����
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
			AlertUtil.alertAndBackPage(response, "�α��� �� �̿����ּ���.");
	        return false;
		}
		
		int role = loginDAO.findRoleById(loginId);
		
		if (role==0) {
			AlertUtil.alertAndBackPage(response, "���� ������ �����ϴ�.");
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
