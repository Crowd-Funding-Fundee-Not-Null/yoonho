package com.boot.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

	@RequestMapping("/board")
	@ResponseBody
	public String hello() {
		return "�ȳ��ϼ��� ȯ���մϴ�";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/question/list";
	}
	
}
