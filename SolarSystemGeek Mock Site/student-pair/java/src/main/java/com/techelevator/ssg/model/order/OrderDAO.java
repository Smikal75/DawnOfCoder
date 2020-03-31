package com.techelevator.ssg.model.order;



public interface OrderDAO {

	public long buy(Order order);
	public void cancelOrder (long OrderId);
	public long getNextId();
	
}

