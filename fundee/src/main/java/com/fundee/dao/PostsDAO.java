package com.fundee.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundee.dto.PostsDTO;
import com.fundee.mapper.PostsMapper;

@Service
public class PostsDAO {

	@Autowired
	PostsMapper postsMapper;
	
	public int maxNum() throws Exception {
		return postsMapper.maxNum();
	}
	
	public void insertData(PostsDTO dto) throws Exception {
		postsMapper.insertData(dto);
	}
	
	// getDataCount �޼ҵ忡 �˻� �Ű����� �߰�
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		return postsMapper.getDataCount(searchKey, searchValue);
	}
	
	// getLists �޼ҵ忡 �˻� �Ű����� �߰�
	public List<PostsDTO> getLists(int start, int end, String searchKey, String searchValue) throws Exception {
		return postsMapper.getLists(start, end, searchKey, searchValue);
	}
	
	// �� ��ȸ �޼ҵ� (��ȯ Ÿ�� ����)
	public PostsDTO getReadData(int posts_Num) throws Exception {
		return postsMapper.getReadData(posts_Num);
	}
	
	public void updateHitCount(int posts_Num) throws Exception {
		postsMapper.updateHitCount(posts_Num);
	}
	
	public void updateData(PostsDTO dto) throws Exception {
		postsMapper.updateData(dto);
	}

	public void deleteData(int posts_Num) throws Exception {
		postsMapper.deleteData(posts_Num);
	}
}