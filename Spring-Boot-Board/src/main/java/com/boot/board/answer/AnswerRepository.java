package com.boot.board.answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	//save, update, delete, findById, findAll �޼ҵ� �ڵ� ����
	
	//����� ���� �޼ҵ�
	//findBySubject, findBySubjectAndContent
	
	
}
