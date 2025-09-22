package com.fundee.dao;

import java.util.List;
import javax.inject.Inject;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundee.dto.BuyListDTO;
import com.fundee.mapper.BuyMapper;

//�̰� �ٿ����� ���� �����̾�
@Service
public class BuyDAO {
	
	@Autowired
	BuyMapper buyMapper;
	
	public int maxNumber() throws Exception {
		return buyMapper.maxNumber();
	}
	
	public void buyData(int proNo) throws Exception {
		buyMapper.buyData(proNo);
	}
	
	public void insertData(BuyListDTO dto) throws Exception {
		buyMapper.insertData(dto);
	}

	public void updateQty(BuyListDTO dto) throws Exception {
		buyMapper.updateQty(dto);
	}
	
	public BuyListDTO checkData(int buyNumber) throws Exception {
		return buyMapper.checkData(buyNumber);
	}
	
	public List<BuyListDTO> getMyDataList(String id) throws Exception {
		return buyMapper.getMyDataList(id);
	}
	

}