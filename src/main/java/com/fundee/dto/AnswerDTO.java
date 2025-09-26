package com.fundee.dto;

import lombok.Data;

@Data
public class AnswerDTO {

	private int answer_num;
	private String id; //답변 작성한 관리자의 ID
	private int question_num; //해당 답변이 어떤 질문의 답변인지를 가리킴
	private String content;
	private String reg_date;
	
	//테이블에 없는 변수
	private String title; //답변 등록 화면에서 띄울 임시 title
	
}
