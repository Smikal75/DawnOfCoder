package com.techelevator.ssg.model.cart;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JDBCOrderItemDAO implements OrderItemDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCOrderItemDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(OrderItem orderItem) {
			
			String sqlInsertorderItem = "INSERT INTO order_items(order_id, product_id, quantity) VALUES (?,?,?)";
			jdbcTemplate.update(sqlInsertorderItem, orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity());
			
		
	}

	@Override
	public List<OrderItem> getAllOrderItemsById(long orderId) {
		List<OrderItem> allOrderItems = new ArrayList<>();
		String sqlSelectAllPosts = "SELECT * FROM order_items WHERE order_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPosts, orderId);
		while (results.next()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(results.getLong("order_id"));
			orderItem.setProductId(results.getLong("product_id"));
			orderItem.setQuantity(results.getInt("quantity"));
			allOrderItems.add(orderItem);
		}
		return allOrderItems;
	}

	@Override
	public void updateQuantity(OrderItem orderItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(long OrderId) {
		// TODO Auto-generated method stub
		
	}




}
