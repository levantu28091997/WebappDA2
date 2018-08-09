package dev.controller.admin;

import java.util.List;

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
import dev.DAO.entity.Product;
@Controller(value = "admin-product")
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("")
	public String index(ModelMap model) {
		model.addAttribute("listproduct", productDAO.getList());
		return "admin/product";
		
	}
	
	@ModelAttribute("listCategory")
	public List<Categories> itemCategory() {
		return categoryDAO.getlistCate();
	}

	@GetMapping({ "delete/{id:[\\d]+}", "delete/{id:[\\d]+}-{confirm}" })
	public String deleteProduct(ModelMap model, @PathVariable Integer id,
			@PathVariable(required = false) String confirm, RedirectAttributes redirectAttributes) {
		if (confirm != null && confirm.equals("yes")) {
			if (productDAO.delete(id)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Xóa thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Xóa thất bại");
			}
			return "redirect:/admin/product";
		}
		model.addAttribute("id", id);
		model.addAttribute("path", "product");
		return "admin/delete";
	}
	
	//add
	@RequestMapping("add")
	public String addProduct(ModelMap model) {
		model.put("Product", new Product());
		return "admin/add-product";
	}

	@PostMapping("add")
	public String addProduct(ModelMap model, @Validated @ModelAttribute("Product") Product product,
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			if (productDAO.insert(product)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Thêm thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Thêm thất bại");
			}
			return "redirect:/admin/product";
		}
		return "admin/add-product";
	}
	
	//edit
	
	@RequestMapping("edit/{id:[\\d]+}")
	public String editProduct(ModelMap model, @PathVariable Integer id) {
		model.put("Product", new Product());
		model.addAttribute("itemProduct", productDAO.getItem(id));
		return "admin/edit-product";
	}

	@PostMapping("edit/{id:[\\d]+}")
	public String editProduct(ModelMap model, @PathVariable Integer id,
			@Validated @ModelAttribute("Product") Product product, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (!result.hasErrors()) {
			if (productDAO.update(product)) {
				redirectAttributes.addFlashAttribute("b", "success");
				redirectAttributes.addFlashAttribute("message", "Sửa thành công");
			} else {
				redirectAttributes.addFlashAttribute("b", "danger");
				redirectAttributes.addFlashAttribute("message", "Sửa thất bại");
			}
			return "redirect:/admin/product";
		}
		return "admin/edit-product";
	}
}