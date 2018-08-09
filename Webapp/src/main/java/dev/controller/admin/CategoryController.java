package dev.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.DAO.CategoryDAO;
import dev.DAO.ProductDAO;
import dev.DAO.entity.Categories;

@Controller(value="admin-categories")
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("")
	public String index(ModelMap model) {
		model.addAttribute("listcategories", categoryDAO.getlistCate());
		return "admin/categories";
		
	}

	
	@GetMapping({ "delete/{id:[\\d]+}", "delete/{id:[\\d]+}-{confirm}" })
	public String deleteCategory(ModelMap model, @PathVariable Integer id,
			@PathVariable(required = false) String confirm, RedirectAttributes redirectAttributes) {
		if (confirm != null && confirm.equals("yes")) {
			if (productDAO.getItem(id) != null) {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Cần xóa hết sản phẩm");
			}else if (categoryDAO.delete(id)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Xóa thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Xóa thất bại");
			}
			return "redirect:/admin/categories";
		}
		model.addAttribute("id", id);
		model.addAttribute("path", "categories");
		return "admin/delete";
	}
	
	//add
	@RequestMapping("add")
	public String addCategory(ModelMap model) {
		model.put("Categories", new Categories());
		return "admin/add-category";
	}

	@PostMapping("add")
	public String addCategory(ModelMap model, @Validated @ModelAttribute("Categories") Categories categories,
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			if (categoryDAO.insert(categories)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Thêm thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Thêm thất bại");
			}
			return "redirect:/admin/categories";
		}
		return "admin/add-category";
	}
	
	//edit
	
	@RequestMapping("edit/{id:[\\d]+}")
	public String editCategory(ModelMap model, @PathVariable Integer id) {
		model.put("Categories", new Categories());
		model.addAttribute("itemCategory", categoryDAO.getItem(id));
		return "admin/edit-category";
	}

	@PostMapping("edit/{id:[\\d]+}")
	public String editCategory(ModelMap model, @PathVariable Integer id,
			@Validated @ModelAttribute("Categories") Categories categories, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			if (categoryDAO.update(categories)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Sửa thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Sửa thất bại");
			}
			return "redirect:/admin/categories";
		}
		return "admin/edit-category";
	}
}
