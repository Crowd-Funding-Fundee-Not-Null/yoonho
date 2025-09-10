package com.boot.board.answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	//save, update, delete, findById, findAll 메소드 자동 구현
	
	//사용자 정의 메소드
	//findBySubject, findBySubjectAndContent
	
	
}
