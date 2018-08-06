package dev.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
	@RequestMapping("/admin")
	public String adminindex() {
		return "admin/index";
	}
//	@RequestMapping("index")
//	public String index() {
//		return "user/index";
//	}
//
//	@RequestMapping("/about")
//	public String about() {
//		return "user/about";
//	}
}
