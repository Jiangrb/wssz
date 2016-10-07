package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/freemarker")
	public String testFreemarkerTemplate(HttpServletRequest request, Model model) {

		System.out.println("aaaaaaaaaaaaaa");
		
		return "test.index";
	}

}
