package dev.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.DAO.ProductDAO;
import dev.DAO.UserDAO;
import dev.DAO.entity.Users;

@Controller
public class IndexUserController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;

	@RequestMapping("index")
	public String index(ModelMap model) {
		model.addAttribute("new_products", productDAO.getNewProducts());
		model.addAttribute("popular_products", productDAO.getPopularProducts());
		return "user/index";
	}

	

	@GetMapping("detail/{id:[\\d]+}")
	public String detail(ModelMap model, @PathVariable Integer id) {
		model.addAttribute("detail", productDAO.getItem(id));
		return "user/details";
	}
	
	@RequestMapping("login")
	public String userlogin(ModelMap model) {
		model.put("User", new Users());
		return "user/login";
	}
	@PostMapping("login")
	public String postLogin(HttpSession session, @ModelAttribute Users user,
			RedirectAttributes redirectAttributes) {
		if (user.getEmail() == null || user.getPassword() == null) {
			redirectAttributes.addFlashAttribute("b", "danger");
			redirectAttributes.addFlashAttribute("message", "Đăng nhập thất bại");
			return "redirect:/auth";
		} else if (userDAO.checkAuth(user.getEmail(), user.getPassword())!=null) {
			session.setAttribute("USER", userDAO.checkAuth(user.getEmail(), user.getPassword()));
			return "redirect:/index";
		}
		redirectAttributes.addFlashAttribute("b", "danger");
		redirectAttributes.addFlashAttribute("message", "Đăng nhập thất bại");
		return "redirect:/login";
	}
	
	@GetMapping("/userlogout")
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/index";
	}
}
