package dev.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.DAO.UserDAO;
import dev.DAO.entity.Users;
@Controller(value="admin-user")
@RequestMapping("/admin/user")
public class UserController {
	@Autowired
	UserDAO userDAO;
	@RequestMapping("")
	public String index(ModelMap model) {
		model.addAttribute("listuser", userDAO.getList());
		return "admin/user";
		
	}

	//add
	@RequestMapping("add")
	public String addUser(ModelMap model) {
		model.put("User", new Users());
		return "admin/add-user";
	}

	@PostMapping("add")
	public String addUser(ModelMap model, @Validated @ModelAttribute("User") Users user,
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			if (userDAO.insert(user)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Thêm thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Thêm thất bại");
			}
			return "redirect:/admin/user";
		}
		return "admin/add-user";
	}
	
	//edit
	
	@RequestMapping("edit/{id:[\\d]+}")
	public String editUser(ModelMap model, @PathVariable Integer id) {
		model.put("User", new Users());
		model.addAttribute("itemuser", userDAO.getItem(id));
		return "admin/edit-user";
	}

	@PostMapping("edit/{id:[\\d]+}")
	public String editUser(ModelMap model, @PathVariable Integer id,
			@Validated @ModelAttribute("User") Users user, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			if (userDAO.update(user)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Sửa thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Sửa thất bại");
			}
			return "redirect:/admin/user";
		}
		return "admin/edit-user";
	}
}
