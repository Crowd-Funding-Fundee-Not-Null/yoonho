package com.boot.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.board.answer.Answer;
import com.boot.board.answer.AnswerRepository;
import com.boot.board.question.Question;
import com.boot.board.question.QuestionRepository;
import com.boot.board.question.QuestionService;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void contextLoads() {
	}

	/*
	@Test
	void save() {
		
		
		Question q1 = new Question();
		q1.setSubject("������ ��Ʈ�� ������?");
		q1.setContent("�˰� �;��.");
		q1.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("JPA�� ������?");
		q2.setContent("JPA �˰� �;��.");
		q2.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q2);
		
		
		Question q3 = new Question();
		q3.setSubject("junit�� ������?");
		q3.setContent("junit �˰� �;��.");
		q3.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q3);
		
		
	}
	
	
	
	@Test
	void findAll() {
		
		//��� ������ ���
		List<Question> lists = questionRepository.findAll();
		
		assertEquals(2, lists.size());
		
		Question q = lists.get(0);
		
		assertEquals("������ ��Ʈ�� ������?", q.getSubject());
		
		
	}
	
	
	
	@Test
	void findSubject() {
		
		Question q = questionRepository.findBySubject("JPA�� ������?");
		assertEquals(2, q.getId());
		
	}
	
	
	
	@Test
	void findSubjectAndContent() {
		
		Question q = questionRepository.findBySubjectAndContent("������ ��Ʈ�� ������?", "�˰� �;��.");
		assertEquals(1, q.getId());
		
	}
	
	
	
	@Test
	void findBySubjectLike() {
		
		List<Question> lists = questionRepository.findBySubjectLike("������%");
		
		Question q = lists.get(0);
		
		assertEquals("�˰� �;��.", q.getContent());
	}
	
	
	
	@Test
	void update() {
		
		Optional<Question> op = questionRepository.findById(3);
		
		assertTrue(op.isPresent());
		
		Question q = op.get();
		q.setSubject("������");
		q.setContent("������ ��Ʈ");
		
		questionRepository.save(q);
		
	}
	
	
	
	@Test
	void replySave() {
		
		Optional<Question> op = questionRepository.findById(4);
		
		assertTrue(op.isPresent());
		
		Question q = op.get();
		
		Answer answer = new Answer();
		answer.setContent("JPA�� ORM�Դϴ�");
		answer.setQuestion(q);
		answer.setCreatedDate(LocalDateTime.now());
		
		answerRepository.save(answer);
		
	}
	
	
	
	@Test
	void replyFind() {
		
		Optional<Answer> op = answerRepository.findById(1);
		
		assertTrue(op.isPresent());
		
		Answer answer = op.get();
		
		assertEquals(4, answer.getQuestion().getId());
		assertEquals("JPA�� ������?", answer.getQuestion().getSubject());
		
		
	}
	
	
	
	@Test
	void replyConnectQuestion() {
		
		Optional<Question> op = questionRepository.findById(4);
		
		assertTrue(op.isPresent());
		
		Question q = op.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("JPA�� ORM�Դϴ�", answerList.get(0).getContent());
		
		
	}
	
	
	
	
	
	
	@Test
	void save300() {
		
		for (int i=1; i<=300; i++) {
			
			String subject = String.format("Test Data : [%03d]", i);
			String content = String.format("Test Content : [%03d]", i);
			
			questionService.create(subject, content);
			
		}
		
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
}
