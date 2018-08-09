package dev.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.DAO.AdminUserDAO;
import dev.DAO.entity.AdminUser;
@Controller(value="admin-auth")
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AdminUserDAO adminuserDAO;

	@RequestMapping("")
	public String login(ModelMap model) {
		model.put("AdminUser", new AdminUser());
		return "auth/login";
	}

	@PostMapping("")
	public String postLogin(HttpSession session, @ModelAttribute AdminUser adminuser,
			RedirectAttributes redirectAttributes) {
		if (adminuser.getEmail() == null || adminuser.getPassword() == null) {
			redirectAttributes.addFlashAttribute("message", "Đăng nhập thất bại");
			return "redirect:/auth";
		} else if (adminuserDAO.checkAuth(adminuser.getEmail(), adminuser.getPassword())) {
			session.setAttribute("LOGIN_EMAIL", adminuser.getEmail());
			session.setAttribute("LOGIN_PASS", adminuser.getPassword());
			return "redirect:/admin";
		}
		redirectAttributes.addFlashAttribute("message", "Đăng nhập thất bại");
		return "redirect:/auth";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN_EMAIL");
		session.removeAttribute("LOGIN_PASS");
		return "redirect:/auth";
	}
}
