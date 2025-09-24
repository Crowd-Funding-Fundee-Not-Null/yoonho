package com.fundee.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AlertUtil {
	
	 public static void init(HttpServletResponse response) {
//		 response.setContentType("text/html; charset=euc-kr");
//		 response.setCharacterEncoding("euc-kr");
		 response.setContentType("text/html; charset=UTF-8");
		 response.setCharacterEncoding("UTF-8");
	 }
	 
	 public static void alert(HttpServletResponse response, String alertText) throws IOException {
		 init(response);
		 PrintWriter out = response.getWriter();
		 out.println("<script>alert('" + alertText +"');</script> ");
		 out.flush();
	 }
	 
	 public static void alertAndMovePage(HttpServletResponse response, String alertText, String nextPage)
	 		throws IOException {
		 init(response);
		 PrintWriter out = response.getWriter();
		 out.println("<script>alert('" + alertText + "'); window.location.href='" + nextPage + "';</script> ");
		 out.flush();
	 }
	 
	 public static void alertAndBackPage(HttpServletResponse response, String alertText) throws IOException {
		 init(response);
		 PrintWriter out = response.getWriter();
		 out.println("<script>alert('" + alertText + "'); history.go(-1);</script>");
		 out.flush();
	 }
	 
	 
}
