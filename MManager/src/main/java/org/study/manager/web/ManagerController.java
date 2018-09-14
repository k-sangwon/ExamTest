package org.study.manager.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.study.manager.dao.ManagerDao;
import org.study.manager.model.Member;
/**
 * 회원관리를 하는 컨트롤러
 * @author user
 *
 */
@Controller
public class ManagerController {

	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	@Autowired
	ManagerDao dao;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		logger.info("/register get called...");
		
		return "registerForm";
	}
	/**
	 *  회원정보를 리스트에 띄어주는 메서드
	 * @param member 회원정보를 담을 것
	 * @param model 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Member member, Model model, RedirectAttributes rttr,HttpServletRequest request) {
			logger.info("/list get called");
			try {
				List<Member> list = dao.list();
				model.addAttribute("list", list);
				
				return "/list";
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return "/list";
	}
	/**
	 * 
	 * @param member
	 * @param member_pw1 비밀번호 1 
	 * @param member_pw2 비밀번호 2
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public String registerProc(Member member, String member_pw1, String member_pw2) {
		logger.info("/register post called...");
		
		
		if (member_pw1.length() > 0 && member_pw1.equals(member_pw2)) {
			member.setMember_pw(member_pw1);
			logger.info("member: " + member + "(" + member_pw1 + ", " + member_pw2 +")");
			
			try {
				dao.insertMember(member);
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "fail2";
			}
			
		} else {
			return "fail";
		}

	}
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)
	@ResponseBody
	public String idCheck(String id) {
		logger.info("idCheck: " + id);
		
		if (dao.existMemberId(id)) {
			return "not available";
		} else {
			return "available";
		}

	}

	
	
}