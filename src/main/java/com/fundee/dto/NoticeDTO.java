package com.fundee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NoticeDTO {

	private int notice_num;
	private String id; //작성한 관리자의 ID
	private String title;
	private String content;
	private int hitcount;
	private String reg_date;
	private int importance; //0:일반, 1:중요힌 공지사항
	
}

