package com.boot.board.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.boot.board.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	public void create(Question question, String content) {
		
		Answer answer = new Answer();
		
		answer.setContent(content);
		answer.setCreatedDate(LocalDateTime.now());
		answer.setQuestion(question);
		
		answerRepository.save(answer);
		
	}
	
	
}
