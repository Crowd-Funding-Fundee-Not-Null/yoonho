package com.fundee.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//JSP�����ϴ°��̾� �����

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fundee.dao.PostsDAO;
import com.fundee.dto.BuyListDTO;
import com.fundee.mapper.BuyMapper;

@Controller
@RequestMapping("/")
public class BuyController {
	
	@Autowired
	private BuyMapper buyMapper;
	
	@Autowired
	PostsDAO postsDAO;
	
	//���� get
	//���Ŵ����� ����â �����°� DB���� �Ȱ� ��µǾ�� �ϴ� â, 
	@RequestMapping(value = "/buyForm", method = RequestMethod.GET)
	public String buyForm(int posts_num, Model model, HttpServletRequest req) throws Exception {
		
		/* ���Ƿ� �ִ� �׽�Ʈ
		buyListDTO.setId("test");
		buyListDTO.setName("�׽�Ʈ");
		buyListDTO.setTitle("����");
		buyListDTO.setBuyPrice(15000);
		buyListDTO.setBuyNumber(0);
		
		buyListDTO.setTotalPrice(buyListDTO.getBuyPrice()*
				buyListDTO.getQty());
		*/
			
		HttpSession session = req.getSession();
		
		if (session.getAttribute("loginId")==null) {
			return "redirect:/posts_list.do";
		}
		
		
		model.addAttribute("dto",postsDAO.getReadData(posts_num));
		return "buyForm";//buyForm.jsp(����â)���� �̵�
	}
	
	
	//���� post
	//�����Ͻðڽ��ϱ� �������� ���� ����, ���� �޼���
	@RequestMapping(value = "/buyForm", method = RequestMethod.POST)
	public String buyData(@ModelAttribute BuyListDTO buyListDTO,
			Model model) {
		
		try {
			
			buyMapper.insertData(buyListDTO);//�μ�Ʈ ������ �۵� �� ����
			
			model.addAttribute("dto",buyListDTO); //�����ؾ��� ����
			
			return "redirect:/buyOk"; //buyOk.jsp(���ſϷ�) �������� �̵�
			
		} catch (Exception e) {
			e.printStackTrace();
			return "buyForm"; // ��ҽ� ������ �̵�����
		}
	}
		
	
	//���ſϷ� get
	//���ſϷ�������(�������� �� ��ݱ����Ѱ� ������)
	@RequestMapping(value = "/buyOk", method = RequestMethod.GET)
	public String buyOk(@ModelAttribute("dto") BuyListDTO dto,
							Model model) { //jsp�� �Ѱܾ� �ϴ°�
	
		model.addAttribute("dto",dto);
		return "buyOk";
	}


}
