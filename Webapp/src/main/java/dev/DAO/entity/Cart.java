package dev.DAO.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private static final int LIMIT_ITEMS = 10;

	private static final int MIN_ITEMS = 1;

	private List<OderDetails> items;

	public Cart() {
		items = new ArrayList<OderDetails>();
	}

	public void add(Product product) {
		int id = product.getId();
		// check item exist
		for (OderDetails e : items) {
			if (e.getProduct().getId() == id) {
				if (e.getQuantity() + 1 < LIMIT_ITEMS) {
					e.setQuantity(e.getQuantity() + 1);
				} else {
					e.setQuantity(LIMIT_ITEMS);
				}

				// done if item exist
				return;
			}
		}

		// add if do not exist
		OderDetails item = new OderDetails();
		item.setProduct(product);
		item.setQuantity(1);
		items.add(item);
	}

	public void update(Product product) {
		OderDetails item = new OderDetails();
		item.setProduct(product);
		item.setQuantity(1);
		// check item exist
		for (OderDetails e : items) {
			if (e.getProduct().getId() == product.getId()) {
				if (e.getQuantity() - 1 >= MIN_ITEMS) {
					e.setQuantity(e.getQuantity() - 1);
				} else {
					e.setQuantity(MIN_ITEMS);
				}
				return;
			}
		}
		items.add(item);
	}

	public void remove(int id) {
		for (OderDetails e : items) {
			if (e.getProduct().getId() == id) {
				items.remove(e);
				return;
			}
		}
	}

	public int getCount() {
		return items.size();
	}

	public float getTotal() {
		float total = 0;
		for (OderDetails e : items) {
			total += (e.getProduct().getPrice() * e.getQuantity());
		}
		return total;
	}

	public List<OderDetails> getItems() {
		return items;
	}

	public void setItems(List<OderDetails> items) {
		this.items = items;
	}

	public static int getLimitItems() {
		return LIMIT_ITEMS;
	}
}
