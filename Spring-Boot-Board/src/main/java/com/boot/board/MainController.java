package com.boot.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/board")
	public String hello() {
		return "�ȳ��ϼ��� ȯ���մϴ�";
	}
	
	
	
}
