package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import services.RegisterService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	RegisterService registerService;

	@RequestMapping("register")
	public String newRegister(HttpServletRequest request, Model model) {
		// just for test mybatise insert into db
		User user = new User("jiangrb", "ABC company", "3432423@qq.com", "122323214", "shenzhen");
		boolean result = registerService.addNewUser(user);
		if (result) {
			return "success";
		}
		return "error";
	}

	public String login(HttpServletRequest request, Model model) {
		// TODO
		return "";
	}

}
