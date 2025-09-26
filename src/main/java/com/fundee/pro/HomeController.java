package com.fundee.pro;

import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fundee.dao.AdminDAO;
import com.fundee.dao.PostsDAO;
import com.fundee.dto.PostsDTO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	PostsDAO postsDAO;
	
	@Autowired
	AdminDAO adminDAO;
	
	
	//메인화면 띄우기
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String active = "home";
		req.setAttribute("active", active);
		
		return "index";
	}
	
	
	//랜덤으로 몇 개의 펀딩상품 데이터를 가져와서 메인화면에 전달
	@ResponseBody
	@RequestMapping(value = "getShuffledLists", method = RequestMethod.GET)
	public List<PostsDTO> getShuffledLists() throws Exception {
		
		int amount = 4;
		
		List<Integer> randomNumList = new ArrayList<Integer>();
		List<Integer> numList = adminDAO.getPostsNums();
		
		int size = numList.size();
		
		
		for (int i=0; i<size; i++) {
			int randomIndex = (int)(Math.random()*(size-i));
			int value = numList.get(randomIndex);
			numList.remove(randomIndex);
			numList.add(value);
		}
		
		for (int i=0; i<amount; i++) {
			if (i==size) break;
			randomNumList.add(numList.get(i));
		}

		List<PostsDTO> lists = adminDAO.get4randomPosts(randomNumList);
		
		Collections.shuffle(lists);
		
		
		return lists;
	}
	
	
	//찜 목록 페이지
	@RequestMapping(value = "wishlist.do", method = RequestMethod.GET)
	public String getWishlist(HttpServletRequest req) throws Exception {
		
		Cookie[] c = req.getCookies();
		List<PostsDTO> lists = new ArrayList<PostsDTO>();
		
		
		String cookieStr = "";
		
		for (int i=0; i<c.length; i++) {
			if (c[i].getName().equals("wishlist")) {
				cookieStr = URLDecoder.decode(c[i].getValue(),"UTF-8");
			}
		}
		
		
		if (cookieStr==null || cookieStr.equals("")) {
			return "wishlist";
		}
		
		//쿠키에서 가져온 값을 가공하여 상품들을 읽어온 뒤 찜 목록에 띄울 list를 채움
		cookieStr = cookieStr.replaceAll("wishlist=", "");
		cookieStr = cookieStr.substring(1,cookieStr.length()-1);
		
		if (cookieStr==null || cookieStr.equals("")) {
			return "wishlist";
		}
		
		String[] cookies = cookieStr.split(",");
		
		
		for (int i=0; i<cookies.length; i++) {
			String[] tempArr = cookies[i].substring(1, cookies[i].length()-1).split("_");
			cookies[i] = tempArr[tempArr.length-1];
			
			PostsDTO postsDTO = postsDAO.getReadData(Integer.parseInt(cookies[i]));
			postsDTO.setImage_file(postsDTO.getImage_file().substring(19));
			
			lists.add(postsDTO);
		}
		
		
		
		req.setAttribute("lists", lists);
		
		return "wishlist";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String index(Model model) {
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value = "menu.do", method = RequestMethod.GET)
	public String menu(Model model) {
		
		return "menu";
	}
	
	
	
	@RequestMapping(value = "about.do", method = RequestMethod.GET)
	public String about(Model model) {
		
		return "about";
	}
	
	
	@RequestMapping(value = "book.do", method = RequestMethod.GET)
	public String book(Model model) {
		
		return "book";
	}
	
	
	
	
	
}
