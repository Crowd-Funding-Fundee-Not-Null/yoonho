package com.fundee.pro;

import java.io.File;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fundee.dao.PostsDAO;
import com.fundee.dto.PostsDTO;
import com.fundee.util.MyUtil;

@Controller
public class PostsController {

	@Autowired
	private PostsDAO postsDAO;

	@Autowired
	private MyUtil myUtil;

	
	@RequestMapping(value = "/created.do" , method = RequestMethod.GET)	
	public String Fundee(HttpServletRequest req) throws Exception {
		return "posts_created";
	}
	

	// 상품 등록 처리
	@RequestMapping(value = "/created_ok.do", method = RequestMethod.POST)
	public String created_ok(PostsDTO dto, @RequestParam(value = "upload", required = false) MultipartFile mf,
	        HttpServletRequest request) throws Exception {

	    // 서버 측 유효성 검사
	    if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
	        throw new IllegalArgumentException("상품 제목은 필수 입력 항목입니다.");
	    }
	    
	    String root = request.getSession().getServletContext().getRealPath("/");
	    String savePath = root + "resources" + File.separator + "uploads";

	    if (mf != null && !mf.isEmpty()) {
	        File saveFile = new File(savePath, mf.getOriginalFilename());
	        mf.transferTo(saveFile);
	        dto.setImage_file(mf.getOriginalFilename());
	    } else {
	        dto.setImage_file(""); // 파일이 없는 경우 빈 문자열로 설정
	    }

	    // DTO를 사용하여 데이터베이스에 데이터 삽입
	    postsDAO.insertData(dto);

	    // 성공 시 리스트 페이지로 이동
	    return "redirect:/posts_list.do";
	}

	@RequestMapping(value = {"/posts_list.do","list.do"})
	public ModelAndView getLists(HttpServletRequest req,
								@RequestParam(defaultValue = "") String searchKey,
								@RequestParam(defaultValue = "") String searchValue) throws Exception {
		
		String pageNum = req.getParameter("pageNum");
		
		int currentPage = (pageNum != null && !pageNum.equals("")) ?
				Integer.parseInt(pageNum) : 1;
				
		int dataCount = postsDAO.getDataCount(searchKey, searchValue);
		
		int numPerPage = 9;
		int numPerBlock = 5;
		
		int totalPage = myUtil.getPagecount(numPerPage, dataCount);
		
		if(currentPage > totalPage) currentPage = totalPage;
		
		int start = (currentPage-1) * numPerPage + 1;
		int end = currentPage * numPerPage;
		
		List<PostsDTO> lists = postsDAO.getLists(start, end, searchKey, searchValue);
		
		String param = "";
		if(searchValue != null && !searchValue.equals("")){
			param = "searchKey=" + searchKey + "&searchValue=" + searchValue + "&";
		}

		String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, numPerBlock, "posts_list.do?"+ param);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists", lists);
		mav.addObject("pageIndexList", pageIndexList);
		mav.addObject("pageNum", currentPage);
		
		mav.setViewName("posts_list");
		return mav;
	}

	// 게시물 상세 페이지
	@RequestMapping(value = "/article.do", method = RequestMethod.GET)
	public ModelAndView article(@RequestParam int postsNum) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		PostsDTO dto = postsDAO.getReadData(postsNum);
		
		if (dto != null) {
			postsDAO.updateHitCount(postsNum);
			mav.addObject("dto", dto);
			mav.setViewName("posts_article");
		} else {
			// 게시물이 없을 경우 처리
			mav.setViewName("redirect:/posts_list.do");
		}
		return mav;
	}

	// 수정 폼으로 이동
	@RequestMapping(value = "/updated.do", method = RequestMethod.GET)
	public ModelAndView updated(@RequestParam int postsNum) throws Exception {
		ModelAndView mav = new ModelAndView();
		PostsDTO dto = postsDAO.getReadData(postsNum);
		mav.addObject("dto", dto);
		mav.setViewName("posts_updated");
		return mav;
	}
	
	// 수정 처리
	@RequestMapping(value = "/updated_ok.do", method = RequestMethod.POST)
	public String updated_ok(PostsDTO dto, @RequestParam(value = "upload", required = false) MultipartFile mf, HttpServletRequest request) throws Exception {

	    String root = request.getSession().getServletContext().getRealPath("/");
	    String savePath = root + "resources" + File.separator + "uploads";

	    if (mf != null && !mf.isEmpty()) {
	        // 기존 파일 삭제
	        String existingImageFile = request.getParameter("existingImageFile");
	        if (existingImageFile != null && !existingImageFile.isEmpty()) {
	            File oldFile = new File(savePath, existingImageFile);
	            if (oldFile.exists()) {
	                oldFile.delete();
	            }
	        }

	        // 새로운 파일 저장
	        String originalFileName = mf.getOriginalFilename();
	        String saveFileName = System.currentTimeMillis() + "_" + originalFileName;
	        File saveFile = new File(savePath, saveFileName);
	        mf.transferTo(saveFile);
	        dto.setImage_file(saveFileName);
	    } else {
	        // 새로운 파일이 없으면 기존 파일명 유지
	        dto.setImage_file(request.getParameter("existingImageFile"));
	    }

	    postsDAO.updateData(dto);

	    return "redirect:/article.do?postsNum=" + dto.getPosts_num();
	}

	// 게시물 삭제
	@RequestMapping(value = "/deleted.do", method = RequestMethod.GET)
	public String deleted(@RequestParam int postsNum, HttpServletRequest request) throws Exception {
	    
	    // 파일도 함께 삭제
	    PostsDTO dto = postsDAO.getReadData(postsNum);
	    if (dto != null && dto.getImage_file() != null && !dto.getImage_file().isEmpty()) {
	        String root = request.getSession().getServletContext().getRealPath("/");
	        String savePath = root + "resources" + File.separator + "uploads";
	        File file = new File(savePath, dto.getImage_file());
	        if (file.exists()) {
	            file.delete();
	        }
	    }
	    
	    postsDAO.deleteData(postsNum);
	    
	    return "redirect:/posts_list.do";
	}
	
	@RequestMapping(value = "/deleted_ok.action", method = RequestMethod.GET)
	public String deleted_ok(@RequestParam int postsNum) throws Exception {
		
		postsDAO.deleteData(postsNum);
		
		return "redirect:/posts_list.do";
	}
}