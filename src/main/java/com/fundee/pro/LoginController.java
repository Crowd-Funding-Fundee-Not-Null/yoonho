package com.fundee.pro;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fundee.dao.LoginDAO;
import com.fundee.dto.LoginDTO;

@Controller
public class LoginController {

    @Autowired
    private LoginDAO loginDAO;   

    // �α��� ��
    @RequestMapping(value="/loginForm", method=RequestMethod.GET)
    public String loginForm() {
        return "loginForm";
    }

    // �α��� ó��
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam String id,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        // DAO���� ���� ��ü ����(LoginDTO)�� ���������� ����
        LoginDTO user = loginDAO.findByIdAndPassword(id, password);

        if (user != null) {
            session.setAttribute("loginUser", user);            // ��ü ��°�� ����
            session.setAttribute("loginId", user.getId());  	// ���̵�
            session.setAttribute("loginName", user.getName());
            session.setAttribute("loginNickname", user.getNickname()); // �г���

            
            // �� ���⼭ ROLE üũ
            if (user.getRole() != null && user.getRole() == 1) {
                return "redirect:/index.do";   // ������ ����
            } else {
                return "redirect:/index.do";    // �Ϲ�ȸ�� ����
            }

        } else {
            model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
            return "loginForm";
        }
    }

    // ȸ������ ��
    @RequestMapping(value="/join", method=RequestMethod.GET)
    public String joinForm() {
        return "join";
    }

    // ȸ������ ó��
    @RequestMapping(value="/join", method=RequestMethod.POST)
    public String join(@ModelAttribute LoginDTO dto, Model model) {

        // ���� ��й�ȣ ��ġ ����
        if (dto.getPassword() == null || !dto.getPassword().equals(dto.getPasswordCheck())) {
            model.addAttribute("message", "��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.");
            return "join";
        }

        // �̸��� �ߺ� Ȯ��
        if (loginDAO.existsByEmail(dto.getEmail()) > 0) {
            model.addAttribute("message", "�̹� ��� ���� �̸����Դϴ�.");
            return "join";
        }

        // role ����
        Integer role = dto.getRole();
        if (role == null || (role != 0 && role != 1)) role = 0;
        dto.setRole(role);

        try {
            int r = loginDAO.insertMember(dto);
            return (r == 1) ? "redirect:/loginForm" : "join";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("message", "�̹� ��� ���� ������ �ֽ��ϴ�. (�̸���/���̵�/�г��� ��)");
            return "join";
        } catch (Exception e) {
            model.addAttribute("message", "ȸ������ �� ������ �߻��߽��ϴ�.");
            return "join";
        }
        
        
        
    }

    // ���̵� ã�� ��
    @RequestMapping(value="/find_id", method=RequestMethod.GET)
    public String findIdForm() {
        return "find_id";
    }

    // ���̵� ã�� ó��
    @RequestMapping(value="/find_id", method=RequestMethod.POST)
    public String findId(@RequestParam String email, Model model) {
        String id = loginDAO.findIdByEmail(email);
        if (id == null) {
            model.addAttribute("message", "��ġ�ϴ� ���̵� ã�� �� �����ϴ�.");
            return "find_id_ok";
        }
        model.addAttribute("foundId", id);
        return "find_id_ok";
    }

    // �̸��� �ߺ� üũ
    @RequestMapping(
        value = {"/checkEmail", "/checkEmail.do"},
        method = RequestMethod.GET,
        produces = "text/plain;charset=UTF-8"
    )
    @ResponseBody
    public String checkEmail(@RequestParam("email") String email) {
        int cnt = loginDAO.existsByEmail(email);
        return String.valueOf(cnt);   // "0" �Ǵ� "1" ��ȯ
    }
    @RequestMapping(
	    value = {"/checkNickname", "/checkNickname.do"},
	    method = RequestMethod.GET,
	    produces = "text/plain;charset=UTF-8"
	)
    
    
	@ResponseBody
	public String checkNickname(@RequestParam("nickname") String nickname) {
	    int cnt = loginDAO.existsByNickname(nickname);
	    return String.valueOf(cnt);  
	}

    //�α׾ƿ�
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate(); // ���� ���� ����
        return "redirect:/index.do"; 
    }
    
    // ��й�ȣ ã�� ��
    @RequestMapping(value="/find_pwd", method=RequestMethod.GET)
    public String findPwdForm() {
        return "find_pwd";
    }

    // ��й�ȣ ã�� ó��
    @RequestMapping(value="/find_pwd", method=RequestMethod.POST)
    public String findPwd(@RequestParam String id,
                          @RequestParam String email,
                          Model model) {
        String pwd = loginDAO.findPwdByIdAndEmail(id, email);

        if (pwd == null) {
            model.addAttribute("message", "��ġ�ϴ� ������ �����ϴ�.");
        } else {
            model.addAttribute("foundPwd", pwd);
        }
        return "find_pwd_ok";
    }

    
    
    
    
    
}

















