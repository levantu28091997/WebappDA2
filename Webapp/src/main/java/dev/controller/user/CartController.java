package dev.controller.user;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.DAO.OderDAO;
import dev.DAO.OderDetailDAO;
import dev.DAO.ProductDAO;
import dev.entity.BaseRespone;
import dev.entity.Cart;
import dev.entity.OderDetails;
import dev.entity.Oders;
import dev.entity.Product;
import dev.entity.Users;

@Controller
public class CartController {
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	OderDAO orderDao;
	
	@Autowired
	OderDetailDAO orderDetailDao;

	@RequestMapping("/cart")
	public String showcart() {
		return "user/cart";
	}

	@RequestMapping("/ordernow/{id:[\\d]+}")
	public String orderNow(@PathVariable(value = "id") Integer id, HttpSession httpSession, ModelMap modelMap)
			throws Exception {

		Cart cart = (Cart) httpSession.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		productDao.getNewProducts();
		Product product = productDao.getItem(id);

		if (product == null) {
			return "redirect:/index";
		} else {
			cart.add(product);
			httpSession.setAttribute("cart", cart);
			return "redirect:/cart";
		}

	}

	@RequestMapping("deleteorder/{id}")
	public String deleteOrder(@PathVariable(value = "id") Integer id, HttpSession httpSession,
			RedirectAttributes redirectAttributes) throws Exception {
		Cart cart = (Cart) httpSession.getAttribute("cart");
		Product product = productDao.getItem(id);

		if (product != null) {
			cart.remove(id);
			redirectAttributes.addFlashAttribute("message", "Xóa thành công");
			return "redirect:/cart";
		}
		redirectAttributes.addFlashAttribute("message", "Xóa thất bại");
		return "redirect:/cart";
	}

	@RequestMapping("checkout")
	public String checkOut(HttpSession session, RedirectAttributes redirectAttributes) {
		Cart cart = (Cart) session.getAttribute("cart");
		Users user = (Users) session.getAttribute("USER");

		if (cart == null || cart.getCount() == 0) {
			redirectAttributes.addFlashAttribute("message", "Xóa thành công");
			return "redirect:/cart";
		} else if (user == null) {
			return "user/login";
		} else {
			Oders order = new Oders();
			order.setUsers(user);
			float total = (float) cart.getTotal();
			order.setTotal(total);
			int quantity = 0;
			for(int i=0;i<cart.getItems().size();i++) {
				quantity += cart.getItems().get(i).getQuantity();
			}
			order.setQuantity(quantity);
			order.setStatus(0);

			try {
				orderDao.insert(order);
				for (OderDetails orderDetail : cart.getOrderDetails()) {
					orderDetail.setOders(order);
					orderDetail.setCreatedAt(new Date());
					orderDetailDao.insert(orderDetail);
				}
				session.removeAttribute("cart");
				redirectAttributes.addFlashAttribute("message", "Đặt sản phẩm thành công !!");
				return "redirect:/cart";
			} catch (Exception e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("message", "Có lỗi khi đặt sản phẩm !!");
				return "redirect:/cart";
			}
		}
	}

}
