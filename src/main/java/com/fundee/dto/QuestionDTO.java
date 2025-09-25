package com.fundee.dto;

import lombok.Data;

@Data
public class QuestionDTO {

	private int question_num;
	private String id;
	private String title;
	private String content;
	private String reg_date;
	private int secret;
	
	private String name;
	private int board_num;
	private boolean answered;
}
