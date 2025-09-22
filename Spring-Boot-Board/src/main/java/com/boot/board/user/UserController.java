package com.boot.board.user;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		
		return "signup_form";
	}
	
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "signup_form";
		}
		
		if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordIncorrect",
					"비밀번호를 다시 확인해주세요.");
			return "signup_form";
		}
		
		try {
			userService.create(userCreateForm.getUserName(), userCreateForm.getPassword1(), 
					userCreateForm.getEmail());
			
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("signupFailed","이미 사용중인 이름입니다.");
			return "signup_form";
			
		} catch (Exception e) {
			bindingResult.reject("signupFailed",e.getMessage());
			return "signup_form";
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping("/login")
	public String login() {
		
		return "login_form";
	}
	
	
	
}
