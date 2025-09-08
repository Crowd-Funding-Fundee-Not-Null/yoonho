package com.boot.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/board")
	public String hello() {
		return "안녕하세요 환영합니다";
	}
	
	
	
}
