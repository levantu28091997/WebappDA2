package dev.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.DAO.OderDAO;
import dev.entity.BaseRespone;
import dev.entity.OderDetails;
import dev.entity.Oders;

@Controller
public class OderController {
	@Autowired
	OderDAO oderDAO;

	@RequestMapping("/admin/oder")
	public String adminoder(ModelMap model) {
		model.addAttribute("listoder", oderDAO.findAll());
		return "admin/oder";
	}

	@GetMapping(value = "admin/setstatus/{id}")
	@ResponseBody
	public String setStatusById(@PathVariable Integer id) throws Exception {
		Oders order = oderDAO.findOne(id);
		order.setStatus(1);
		try {
			oderDAO.merge(order);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@GetMapping(value = "getorderbyid/{id}")
	public @ResponseBody BaseRespone getOrderById(@PathVariable Integer id) throws Exception {
		Oders oder = oderDAO.findOne(id);
		List<OderDetails> lst = oder.getLstOrderDetail();
		return new BaseRespone("hanh", "success");
	}

}
