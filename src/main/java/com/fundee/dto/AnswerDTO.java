package com.fundee.dto;

import lombok.Data;

@Data
public class AnswerDTO {

	private int answer_num;
	private String id; //�亯 �ۼ��� �������� ID
	private int question_num; //�ش� �亯�� � ������ �亯������ ����Ŵ
	private String content;
	private String reg_date;
	
	//���̺� ���� ����
	private String title; //�亯 ��� ȭ�鿡�� ��� �ӽ� title
	
}
