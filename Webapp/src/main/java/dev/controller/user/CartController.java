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
import dev.DAO.entity.Cart;
import dev.DAO.entity.OderDetails;
import dev.DAO.entity.Oders;
import dev.DAO.entity.Product;
import dev.DAO.entity.Users;

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

		Product product = productDao.getItem(id);
		if (product == null) {
			return "redirect:/index";
		} else {
			Cart cart = (Cart) httpSession.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
			}
			cart.add(product);
			httpSession.setAttribute("cart", cart);
			return "redirect:/cart";
		}

	}

	@RequestMapping("deleteorder/{id}")
	public String deleteOrder(@PathVariable(value = "id") Integer id, HttpSession httpSession,
			RedirectAttributes redirectAttributes) throws Exception {
		Product product = productDao.getItem(id);

		if (product != null) {
			Cart cart = (Cart) httpSession.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
			}
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
			redirectAttributes.addFlashAttribute("message", "Giỏ hàng không tồn tại.");
			return "redirect:/cart";
		} else if (user == null) {
			return "redirect:/login";
		} else {

			Oders order = new Oders();
			order.setUsers(user);
			order.setTotal(cart.getTotal());
			order.setStatus(0);
			order.setDate(new Date());

			try {
				orderDao.insert(order);
				for (OderDetails orderDetail : cart.getItems()) {
					orderDetail.setOders(order);
					orderDetail.setTotal(orderDetail.getProduct().getPrice() * orderDetail.getQuantity());
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
