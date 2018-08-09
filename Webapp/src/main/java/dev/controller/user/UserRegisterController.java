package dev.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.DAO.UserDAO;
import dev.DAO.entity.Users;

@Controller
@RequestMapping("/register")
public class UserRegisterController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping("")
	public String addUser(ModelMap model) {
		model.put("User", new Users());
		return "user/register";
	}

	@PostMapping("")
	public String register(ModelMap model, @Validated @ModelAttribute("User") Users user, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			if (userDAO.insert(user)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Thêm thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Thêm thất bại");
			}
			return "redirect:/login";
		}
		return "user/register";
	}
	
}
