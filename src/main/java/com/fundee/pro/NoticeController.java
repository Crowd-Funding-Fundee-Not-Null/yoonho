package com.fundee.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fundee.dao.LoginDAO;
import com.fundee.dao.NoticeDAO;
import com.fundee.dao.QnaDAO;
import com.fundee.dto.AnswerDTO;
import com.fundee.dto.NoticeDTO;
import com.fundee.dto.QuestionDTO;
import com.fundee.util.MyUtil;


@Controller
public class NoticeController {

	@Autowired
	NoticeDAO noticeDAO;
	
	@Autowired
	MyUtil myUtil;
	
	@Autowired
	LoginDAO loginDAO;
	
	@Autowired
	QnaDAO qnaDAO;
	
	
	//==========NOTICE 부분===========
	
	//공지사항 메인 페이지
	@RequestMapping(value = "notice.do", method = RequestMethod.GET)
	public String notice(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String cp = req.getContextPath();
		
		
		List<NoticeDTO> importantLists = noticeDAO.getImportantNotice();
		
		String pageNum = req.getParameter("pageNum");
		
		int currentPage = 1;
		
		if (pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		int dataCount = noticeDAO.getDataCount();
		
		int numPerPage = 10-importantLists.size();
		int totalPage = myUtil.getPagecount(numPerPage, dataCount);
		int numPerBlock = 5;
		
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		
		int start = (currentPage-1)*numPerPage+1;
		int end = start+numPerPage-1;
		
		String listUrl = cp + "/notice.do";
		
		List<NoticeDTO> allLists = noticeDAO.getAllNotice(start,end);
		
		String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, numPerBlock, listUrl);
		
		
		
		
		req.setAttribute("pageIndexList", pageIndexList);
		req.setAttribute("dataCount", dataCount);
		req.setAttribute("currentPage", currentPage);
		
		
		req.setAttribute("importantLists", importantLists);
		req.setAttribute("allLists", allLists);
		
		String active = "notice";
		req.setAttribute("active", active);
		
		return "notice";
	}
	
	
	//공지사항 상세 페이지
	@RequestMapping(value = "notice_detail.do", method = RequestMethod.GET)
	public String notice_detail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		String pageNum = req.getParameter("pageNum");
		
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		
		noticeDAO.updateNoticeHitCount(notice_num);
		
		NoticeDTO dto = noticeDAO.getNoticeDetail(notice_num);
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		
		
		HttpSession session = req.getSession();
		
		
		//관리자인지 확인
		int role = 0;
		String loginId = (String)session.getAttribute("loginId");
		
		if (loginId!=null && !loginId.equals("")) {
			role = loginDAO.findRoleById(loginId);
		}
		
		
		req.setAttribute("role", role);
		req.setAttribute("dto", dto);
		req.setAttribute("notice_num", notice_num);
		req.setAttribute("pageNum", pageNum);
		
		String active = "notice";
		req.setAttribute("active", active);
		
		return "notice_detail";
	}
	
	
	//공지사항 작성 페이지
	@RequestMapping(value = "notice_write.do", method = RequestMethod.GET)
	public String notice_write(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		String pageNum = req.getParameter("pageNum");
		
		req.setAttribute("pageNum", pageNum);
		
		String active = "notice";
		req.setAttribute("active", active);
		
		return "notice_write";
	}
	
	
	//공지사항 작성 후 등록
	@RequestMapping(value = "notice_write.do", method = RequestMethod.POST)
	public String notice_write(NoticeDTO dto, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		HttpSession session = req.getSession();
		
		int maxNum = noticeDAO.getMaxNum();
		
		dto.setNotice_num(maxNum+1);
		dto.setId((String)session.getAttribute("loginId")); //나중에 세션 완료되면 작성한 관리자 아이디를 받아오도록 수정해야함
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setImportance(Integer.parseInt(req.getParameter("importance")));
		
		noticeDAO.insertNotice(dto);
		
		
		return "redirect:/notice.do";
	}
	
	
	// 공지사항 삭제
	@RequestMapping(value = "notice_delete.do", method = RequestMethod.GET)
	public String notice_delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		int num = Integer.parseInt(req.getParameter("notice_num"));
		String pageNum = req.getParameter("pageNum");
		
		noticeDAO.deleteNotice(num);
		
		return "redirect:/notice.do";
	}
	
	
	
	
	
	
	
	//==========QNA 부분===========
	
	
	
	// QNA 메인 페이지
	@RequestMapping(value = "qna.do", method = RequestMethod.GET)
	public String qna(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String cp = req.getContextPath();
		
		
		String pageNum = req.getParameter("pageNum");
		
		int currentPage = 1;
		
		if (pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		int dataCount = qnaDAO.getQuestionDataCount();
		
		int numPerPage = 10;
		int totalPage = myUtil.getPagecount(numPerPage, dataCount);
		int numPerBlock = 5;
		
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		
		int start = (currentPage-1)*numPerPage+1;
		int end = start+numPerPage-1;
		
		String listUrl = cp + "/qna.do";
		
		List<QuestionDTO> questionLists = qnaDAO.getAllQuestion(start, end);
		
		
		int count = 0;
		for (QuestionDTO dto : questionLists) {
			dto.setName(qnaDAO.getMemberDetail(dto.getId()).getNickname());
			dto.setReg_date(dto.getReg_date().substring(0,10));
			dto.setBoard_num(dataCount-(currentPage-1)*numPerPage-count);
			dto.setAnswered(qnaDAO.getAnswerCountOfQuestion(dto.getQuestion_num())==0?false:true);
			count++;
		}
		
		
		
		String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, numPerBlock, listUrl);
		
		req.setAttribute("pageIndexList", pageIndexList);
		req.setAttribute("dataCount", dataCount);
		req.setAttribute("currentPage", currentPage);
		
		req.setAttribute("lists", questionLists);
		
		String active = "qna";
		req.setAttribute("active", active);
		
		return "qna";
	}
	
	
	@RequestMapping(value = "qna_detail.do", method = RequestMethod.GET)
	public String qna_detail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		HttpSession session = req.getSession();
		
		String pageNum = req.getParameter("pageNum");
		
		int question_num = Integer.parseInt(req.getParameter("question_num"));
		
		QuestionDTO questionDTO = qnaDAO.getQuestionDetail(question_num);
		
		
		questionDTO.setContent(questionDTO.getContent().replaceAll("\n", "<br/>"));
		
		
		if (qnaDAO.getAnswerCountOfQuestion(questionDTO.getQuestion_num())>0) {
			questionDTO.setAnswered(true);
			AnswerDTO answerDTO = qnaDAO.getAnswer(question_num);
			answerDTO.setContent(answerDTO.getContent().replaceAll("\n", "<br/>"));
			req.setAttribute("answerDTO", answerDTO);
		} else {
			questionDTO.setAnswered(false);
		}
		
		questionDTO.setAnswered(qnaDAO.getAnswerCountOfQuestion(questionDTO.getQuestion_num())==0?false:true);
		
		int role = 0;
		int isAuthorized = 0;
		
		
		String loginId = (String)session.getAttribute("loginId");
		
		if (loginId!=null && !loginId.equals("")) {
			role = loginDAO.findRoleById(loginId);
			if (loginId.equals(questionDTO.getId())) {
				isAuthorized = 1;
			}
		}
		
		
		req.setAttribute("isAuthorized", isAuthorized);
		req.setAttribute("role", role);
		req.setAttribute("dto", questionDTO);
		req.setAttribute("question_num", question_num);
		req.setAttribute("pageNum", pageNum);
		
		String active = "qna";
		req.setAttribute("active", active);
		
		return "qna_detail";
	}
	
	
	
	@RequestMapping(value = "question_delete.do", method = RequestMethod.GET)
	public String question_delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		int question_num = Integer.parseInt(req.getParameter("question_num"));
		String pageNum = req.getParameter("pageNum");
		
		
		if (qnaDAO.getAnswerCountOfQuestion(question_num)>0) {
			qnaDAO.deleteAnswerOfQuestion(question_num);
		}
		
		
		qnaDAO.deleteQuestion(question_num);
		
		return "redirect:/qna.do?pageNum="+pageNum;
	}
	
	
	
	
	@RequestMapping(value = "question_write.do", method = RequestMethod.GET)
	public String question_write(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		String pageNum = req.getParameter("pageNum");
		
		req.setAttribute("pageNum", pageNum);
		
		String active = "qna";
		req.setAttribute("active", active);
		
		return "question_write";
	}
	
	
	
	
	@RequestMapping(value = "question_write.do", method = RequestMethod.POST)
	public String question_write(QuestionDTO dto, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		HttpSession session = req.getSession();
		
		int maxNum = qnaDAO.getQuestionMaxNum();
		
		dto.setQuestion_num(maxNum+1);
		dto.setId((String)session.getAttribute("loginId")); //나중에 세션 완료되면 작성한 관리자 아이디를 받아오도록 수정해야함
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setSecret(Integer.parseInt(req.getParameter("secret")));
		
		qnaDAO.insertQuestion(dto);
		
		
		return "redirect:/qna.do";
	}
	
	
	
	@RequestMapping(value = "answer_write.do", method = RequestMethod.GET)
	public String answer_write(int question_num,HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		String pageNum = req.getParameter("pageNum");
		QuestionDTO dto = qnaDAO.getQuestionDetail(question_num);
		
		
		dto.setTitle("답변 : " + dto.getTitle());
		
		
		req.setAttribute("dto", dto);
		req.setAttribute("pageNum", pageNum);
		
		String active = "qna";
		req.setAttribute("active", active);
		
		return "answer_write";
	}
	
	
	@RequestMapping(value = "answer_write.do", method = RequestMethod.POST)
	public String answer_write(AnswerDTO dto, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		HttpSession session = req.getSession();
		
		int maxNum = qnaDAO.getAnswerMaxNum();
		
		dto.setAnswer_num(maxNum+1);
		dto.setId((String)session.getAttribute("loginId")); //나중에 세션 완료되면 작성한 관리자 아이디를 받아오도록 수정해야함
		
		qnaDAO.insertAnswer(dto);
		
		
		
		return "redirect:/qna.do";
	}
	
	
	@RequestMapping(value = "answer_delete.do", method = RequestMethod.GET)
	public String answer_delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		int question_num = Integer.parseInt(req.getParameter("question_num"));
		int answer_num = Integer.parseInt(req.getParameter("answer_num"));
		String pageNum = (String)req.getParameter("pageNum");
		
		
		System.out.println(answer_num+","+question_num+","+pageNum);
		
		
		qnaDAO.deleteAnswer(answer_num);
		
		return "redirect:/qna_detail.do?question_num="+question_num+"&pageNum="+pageNum;
	}
	
	
	
	
}
