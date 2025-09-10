package com.jdbc.springweb;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jdbc.dao.BoardDAO;
import com.jdbc.dto.BoardDTO;
import com.jdbc.util.MyUtil;

@Controller
public class BoardController {

	@Autowired //servlet-context를 통한 dao의존성 주입
	@Qualifier("boardDAO")
	BoardDAO dao;
	
	@Autowired
	MyUtil myUtil;
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	
	
	
	/*
	@RequestMapping(value = "/created.action", method = {RequestMethod.GET})
	public String created() {
		return "bbs/created";
	}
	*/
	
	
	
	
	@RequestMapping(value = "/created.action")
	public ModelAndView created() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/created");
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/created_ok.action", method = {RequestMethod.POST})
	public String created_ok(BoardDTO dto, HttpServletRequest req) {
		
		int maxNum = dao.getMaxNum();
		
		dto.setNum(maxNum+1);
		dto.setIpAddr(req.getRemoteAddr());
		
		dao.insertData(dto);
		
		return "redirect:/list.action";
	}
	
	
	
	
	@RequestMapping(value = "/list.action", method = {RequestMethod.GET})
	public String list(HttpServletRequest req) throws Exception {
		
		String cp = req.getContextPath();
		
		String pageNum = req.getParameter("pageNum");
		
		int currentPage = 1;
		
		if (pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		String searchKey = req.getParameter("searchKey");
		String searchValue = req.getParameter("searchValue");
		
		if (searchValue==null) {
			searchKey = "subject";
			searchValue = "";
		} else {
			if (req.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}
		
		int dataCount = dao.getDataCount(searchKey, searchValue);
		
		int numPerPage = 5;
		int totalPage = myUtil.getPagecount(numPerPage, dataCount);
		int numPerBlock = 5;
		
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		
		int start = (currentPage-1)*numPerPage+1;
		int end = start+numPerPage-1;
		
		List<BoardDTO> lists = dao.getLists(start,end,searchKey,searchValue);
		
		String param = "";
		if (searchValue!=null && !searchValue.equals("")) {
			param = "searchKey="+searchKey+"&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
		}
		
		String listUrl = cp + "/list.action";
		
		if (!param.equals("")) {
			listUrl += "?" + param;
		}
		
		String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, numPerBlock, listUrl);
		
		
		//작성글 확인 주소
		String articleUrl = cp+"/article.action?pageNum="+currentPage;
		
		if (!param.equals("")) {
			articleUrl += "&" + param;
		}
		
		
		//포워딩 페이지에 넘길 데이터
		req.setAttribute("lists", lists);
		req.setAttribute("pageIndexList", pageIndexList);
		req.setAttribute("dataCount", dataCount);
		req.setAttribute("articleUrl", articleUrl);
		
		return "bbs/list";
	}
	
	
	
	
	@RequestMapping(value = "/article.action", method = {RequestMethod.GET}) 
	public ModelAndView article(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String cp = req.getContextPath();
		
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		
		String searchKey = req.getParameter("searchKey");
		String searchValue = req.getParameter("searchValue");
		
		if (searchValue!=null) {
			if (req.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
			}
		} else {
			searchKey = "subject";
			searchValue = "";
		}
		
		dao.updateHitCount(num);
		
		BoardDTO dto = dao.getReadData(num);
		
		if (dto==null) {
			//서블릿에서 화면 넘기는 방법
			//String url = cp+"/list.action";
			//resp.sendRedirect(url);
			
			//String 타입으로 return하여 화면 넘기는 방법
			//return "redirect:/list.action";
			
			//ModelAndView 타입으로 return하여 화면 넘기는 방법
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/list.action");
			
			return mav;
		}
		
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		
		String param = "pageNum=" + pageNum;
		if (searchValue!=null && !searchValue.contentEquals("")) {
			param += "&searchKey=" + searchKey + "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
		}
		
		/* 
		String 타입으로 return하여 화면 넘기는 방법
		req.setAttribute("dto", dto);
		req.setAttribute("params", param);
		req.setAttribute("lineSu", lineSu);
		req.setAttribute("pageNum", pageNum);
		
		return "bbs/article";
		*/
		
		//ModelAndView 타입으로 return하여 화면 넘기는 방법
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dto",dto);
		mav.addObject("params",param);
		mav.addObject("lineSu",lineSu);
		mav.addObject("pageNum",pageNum);
		
		mav.setViewName("bbs/article");
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/updated.action", method = {RequestMethod.GET,RequestMethod.POST}) 
	public String updated(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String cp = req.getContextPath();
		
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		
		String searchKey = req.getParameter("searchKey");
		String searchValue = req.getParameter("searchValue");
		
		if (searchValue!=null) {
			if (req.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
			}
		} else {
			searchKey = "subject";
			searchValue = "";
		}
		
		BoardDTO dto = dao.getReadData(num);
		
		if (dto==null) {
			return "redirect:/list.action";
		}
		
		String param = "pageNum=" + pageNum;
		if (searchValue!=null && !searchValue.contentEquals("")) {
			param += "&searchKey=" + searchKey + "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
		}
		
		req.setAttribute("dto", dto);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("params", param);
		req.setAttribute("searchKey", searchKey);
		req.setAttribute("searchValue", searchValue);
		
		return "bbs/updated";
	}
	
	
	
	
	@RequestMapping(value = "/updated_ok.action", method = {RequestMethod.GET,RequestMethod.POST}) 
	public String updated_ok(BoardDTO dto, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String pageNum = req.getParameter("pageNum");
		String searchKey = req.getParameter("searchKey");
		String searchValue = req.getParameter("searchValue");
		
//		BoardDTO dto = new BoardDTO(); //매개변수에 dto 추가하면 자동 적용됨
//		
//		dto.setNum(Integer.parseInt(req.getParameter("num")));
//		dto.setSubject(req.getParameter("subject"));
//		dto.setName(req.getParameter("name"));
//		dto.setEmail(req.getParameter("email"));
//		dto.setPwd(req.getParameter("pwd"));
//		dto.setContent(req.getParameter("content"));
		
		dao.updateData(dto);
		
		String param = "pageNum=" + pageNum;
		if (searchValue!=null && !searchValue.contentEquals("")) {
			param += "&searchKey=" + searchKey + "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
		}
		
		return "redirect:/list.action?" + param;
	}
	
	
	
	
	@RequestMapping(value = "/deleted_ok.action", method = {RequestMethod.GET,RequestMethod.POST}) 
	public String deleted_ok(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		
		String searchKey = req.getParameter("searchKey");
		String searchValue = req.getParameter("searchValue");
		
		dao.deleteData(num);
		
		String param = "pageNum=" + pageNum;
		if (searchValue!=null && !searchValue.contentEquals("")) {
			param += "&searchKey=" + searchKey + "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
		}
		
		return "redirect:/list.action?" + param;
	}
	
	
	
	
	
	
	
	
	
	
	
}
