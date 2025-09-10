package com.boot.board.question;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.board.answer.AnswerForm;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question") //prefix
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;
	
	
	@RequestMapping("/list")
	public String list(Model model, @PageableDefault Pageable pageable) {
		
		Page<Question> paging = questionService.getLists(pageable);
		
		model.addAttribute("paging",paging);
		
		return "question_list";
	}
	
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id,
			AnswerForm answerForm) {
		
		Question question = questionService.getQuestion(id);
		
		model.addAttribute("question",question);
		
		return "question_detail";
	}
	
	
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		
		return "question_form";
	}
	
	
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		
		questionService.create(questionForm.getSubject(),questionForm.getContent());
		
		return "redirect:/question/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
