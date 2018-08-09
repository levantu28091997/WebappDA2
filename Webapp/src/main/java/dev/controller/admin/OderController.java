package dev.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.DAO.OderDAO;
import dev.DAO.entity.Oders;

@Controller
public class OderController {
	@Autowired
	OderDAO oderDAO;

	@RequestMapping("/admin/oder")
	public String adminoder(ModelMap model) {
		model.addAttribute("listoder", oderDAO.findAll());
		return "admin/oder";
	}

	@RequestMapping("/admin/oder/{id}")
	public String adminoder(ModelMap model, @PathVariable Integer id) {
		model.addAttribute("oder", oderDAO.findOne(id));
		return "admin/oder-detail";
	}
	@RequestMapping("/admin/odersu/{id}")
	public String adminodersu(ModelMap model, @PathVariable Integer id) {
		model.addAttribute("oder", oderDAO.findOne(id));
		return "admin/oder-detail-su";
	}

	@RequestMapping("/admin/accept/{id}")
	public String setStatusById(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		Oders order = oderDAO.findOne(id);
		order.setStatus(1);
		if (oderDAO.merge(order)) {
			redirectAttributes.addFlashAttribute("b", "success");
			redirectAttributes.addFlashAttribute("message", "Xác nhận thành công");
			return "redirect:/admin/oder";
		} else {
			redirectAttributes.addFlashAttribute("b", "danger");
			redirectAttributes.addFlashAttribute("message", "Xác nhận thất bại");
			return "redirect:/admin/oder/" + id;
		}
	}

}
