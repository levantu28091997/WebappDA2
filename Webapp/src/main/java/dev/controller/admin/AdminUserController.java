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

import dev.DAO.AdminUserDAO;
import dev.DAO.entity.AdminUser;
@Controller(value="admin-adminuser")
@RequestMapping("/admin/adminuser")
public class AdminUserController {
	@Autowired
	AdminUserDAO adminuserDAO;
	@RequestMapping("")
	public String index(ModelMap model) {
		model.addAttribute("listadminuser", adminuserDAO.getList());
		return "admin/adminuser";
		
	}
	
	//edit
	
		@RequestMapping("edit/{id:[\\d]+}")
		public String editAdminUser(ModelMap model, @PathVariable Integer id) {
			model.put("AdminUser", new AdminUser());
			model.addAttribute("itemadminuser", adminuserDAO.getItem(id));
			return "admin/edit-adminuser";
		}

		@PostMapping("edit/{id:[\\d]+}")
		public String editAdminUser(ModelMap model, @PathVariable Integer id,
				@Validated @ModelAttribute("AdminUser") AdminUser adminuser, BindingResult result,
				RedirectAttributes redirectAttributes) {
			if (!result.hasErrors()) {
				if (adminuserDAO.update(adminuser)) {
					redirectAttributes.addFlashAttribute("b", "success");
					redirectAttributes.addFlashAttribute("message", "Sửa thành công");
				} else {
					redirectAttributes.addFlashAttribute("b", "danger");
					redirectAttributes.addFlashAttribute("message", "Sửa thất bại");
				}
				return "redirect:/admin/adminuser";
			}
			return "admin/edit-adminuser";
		}
		
}
