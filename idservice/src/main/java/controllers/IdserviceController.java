package controllers;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Client;
import services.IClientService;

@Controller
@RequestMapping("/clients")
public class IdserviceController {

	@Resource
	private IClientService clientServcie;

	@RequestMapping("/showAllClents")
	public String toIndex(HttpServletRequest request, Model model) {
		Set<Client> clients = clientServcie.getAllClents();
		model.addAttribute("clients", clients);
		System.out.println("clients=====>" + clients.toString());
		model.addAttribute("value1", "test111");
		return "clients";
	}

}
