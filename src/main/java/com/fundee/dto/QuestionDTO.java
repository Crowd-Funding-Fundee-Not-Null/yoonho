package com.fundee.dto;

import lombok.Data;

@Data
public class QuestionDTO {

	private int question_num;
	private String id; //질문자 ID
	private String title;
	private String content;
	private String reg_date;
	private int secret; //0:전체공개, 1:비밀글
	
	//테이블에 없는 변수
	private String name; //질문자 이름
	private int board_num; //게시판에 띄울 게시글 번호
	private boolean answered; //해당 질문에 답변이 달렸는지 여부
}
