package controllers;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import liquibase.exception.LiquibaseException;
import services.LiquibaseServcie;

@Controller
@RequestMapping("/db")
public class LiquibaseController {

	static Logger logger = Logger.getLogger(LiquibaseController.class);

	@Resource
	LiquibaseServcie liquibaseServcie;

	@RequestMapping("/init")
	public String initDB(HttpServletRequest request, Model model) {
		try {
			liquibaseServcie.initDB();
			logger.info("init db success");
			model.addAttribute("result", true);
			model.addAttribute("message", "init db success");
		} catch (SQLException e) {
			model.addAttribute("result", false);
			model.addAttribute("message", "init db exception: " + e);
			logger.error("init db exception: ",e);
		} catch (LiquibaseException e) {
			model.addAttribute("result", false);
			model.addAttribute("message", "init db exception: " + e);
			logger.error("init db exception: ",e);
		}
		return "liquibse.result";
	}

}
