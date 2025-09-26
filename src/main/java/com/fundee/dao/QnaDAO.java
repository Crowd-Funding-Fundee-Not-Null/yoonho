package com.fundee.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundee.dto.AnswerDTO;
import com.fundee.dto.LoginDTO;
import com.fundee.dto.NoticeDTO;
import com.fundee.dto.QuestionDTO;
import com.fundee.mapper.NoticeMapper;
import com.fundee.mapper.QnaMapper;

import lombok.RequiredArgsConstructor;

@Service
public class QnaDAO {

	@Autowired
	QnaMapper qnaMapper;
	
	//QUESTION 부분
	public List<QuestionDTO> getAllQuestion(int start, int end) throws Exception {
		return qnaMapper.getAllQuestion(start, end);
	}
	
	public int getQuestionDataCount() throws Exception {
		return qnaMapper.getQuestionDataCount();
	}
	
	public QuestionDTO getQuestionDetail(int question_num) throws Exception {
		return qnaMapper.getQuestionDetail(question_num);
	}
	
	public int getQuestionMaxNum() throws Exception {
		return qnaMapper.getQuestionMaxNum();
	}
	
	public void insertQuestion(QuestionDTO dto) throws Exception {
		qnaMapper.insertQuestion(dto);
	}
	
	public void deleteQuestion(int question_num) throws Exception {
		qnaMapper.deleteQuestion(question_num);
	}
	
	
	//ANSWER 부분
	public int getAnswerMaxNum() throws Exception {
		return qnaMapper.getAnswerMaxNum();
	}
	
	public int getAnswerCountOfQuestion(int question_num) throws Exception {
		return qnaMapper.getAnswerCountOfQuestion(question_num);
	}
	
	public AnswerDTO getAnswer(int question_num) throws Exception {
		return qnaMapper.getAnswer(question_num);
	}
	
	public void insertAnswer(AnswerDTO dto) throws Exception {
		qnaMapper.insertAnswer(dto);
	}

	public void deleteAnswer(int answer_num) throws Exception {
		qnaMapper.deleteAnswer(answer_num);
	}
	
	public void deleteAnswerOfQuestion(int question_num) throws Exception {
		qnaMapper.deleteAnswerOfQuestion(question_num);
	}
	
	
	
	
	public LoginDTO getMemberDetail(String id) throws Exception {
		return qnaMapper.getMemberDetail(id);
	}
	
	
	
	
}
