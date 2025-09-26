package com.fundee.dto;

import lombok.Data;

@Data
public class QuestionDTO {

	private int question_num;
	private String id; //������ ID
	private String title;
	private String content;
	private String reg_date;
	private int secret; //0:��ü����, 1:��б�
	
	//���̺� ���� ����
	private String name; //������ �̸�
	private int board_num; //�Խ��ǿ� ��� �Խñ� ��ȣ
	private boolean answered; //�ش� ������ �亯�� �޷ȴ��� ����
}
