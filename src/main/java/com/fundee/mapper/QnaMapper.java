package com.fundee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.fundee.dto.AnswerDTO;
import com.fundee.dto.LoginDTO;
import com.fundee.dto.NoticeDTO;
import com.fundee.dto.QuestionDTO;

@Mapper
public interface QnaMapper {

	//QUESTION 부분
	public List<QuestionDTO> getAllQuestion(@Param("start") int start, @Param("end") int end);
	
	public int getQuestionDataCount();
	
	public QuestionDTO getQuestionDetail(int question_num);
	
	public int getQuestionMaxNum();
	
	public void insertQuestion(QuestionDTO dto);
	
	public void deleteQuestion(int question_num);
	
	
	//ANSWER 부분
	public int getAnswerMaxNum();
	
	public int getAnswerCountOfQuestion(int question_num);
	
	public AnswerDTO getAnswer(int question_num);
	
	public void insertAnswer(AnswerDTO dto);
	
	public void deleteAnswer(int answer_num);
	
	public void deleteAnswerOfQuestion(int question_num);
	
	
	
	
	//Member 정보 가져오기
	public LoginDTO getMemberDetail(String id);
	
	
	
	
}