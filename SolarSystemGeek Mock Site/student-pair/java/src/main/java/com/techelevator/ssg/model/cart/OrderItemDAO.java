package com.techelevator.ssg.model.cart;

import java.util.List;



public interface OrderItemDAO {
// CRUD
	public void save(OrderItem orderItem);
	public List<OrderItem> getAllOrderItemsById(long orderId);
	public void updateQuantity (OrderItem orderItem);
	public void cancelOrder (long OrderId);

	
	
}

