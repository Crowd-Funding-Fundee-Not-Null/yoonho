package com.fundee.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fundee.dao.LoginDAO;
import com.fundee.dao.QnaDAO;
import com.fundee.dto.LoginDTO;
import com.fundee.dto.QuestionDTO;
import com.fundee.util.AlertUtil;

public class QuestionInterceptor implements HandlerInterceptor {

	@Autowired
	QnaDAO qnaDAO;
	
	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		int question_num = Integer.parseInt(request.getParameter("question_num"));
		
		String loginId = (String)session.getAttribute("loginId");
		
		QuestionDTO questionDTO = qnaDAO.getQuestionDetail(question_num);
		int secret = questionDTO.getSecret();
		
		
		if (secret==1) {
			
			if (loginId==null || !loginId.equals(questionDTO.getId()) &&
					loginDAO.findRoleById(loginId)!=1) {
				AlertUtil.alertAndBackPage(response, "해당 게시글은 비밀글입니다.");
				return false;
			}
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
