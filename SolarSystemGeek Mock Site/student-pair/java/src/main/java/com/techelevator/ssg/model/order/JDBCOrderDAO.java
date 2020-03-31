package com.techelevator.ssg.model.order;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JDBCOrderDAO implements OrderDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCOrderDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public long buy(Order order) {
		long orderId =getNextId();
		String sqlInsertorderItem = 
				"INSERT INTO orders(order_id, customer_name, street_address1, street_address2, city, state, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertorderItem, 
				orderId,
				order.getCustomerName(), 
				order.getStreetAddress1(),
				order.getStreetAddress2(),
				order.getCity(),
				order.getState(),
				order.getZipcode());
				
		return orderId;
	}


	@Override
	public void cancelOrder(long OrderId) {
		// TODO Auto-generated method stub

	}

		public long getNextId() {
		String sqlSelectNextId = "SELECT MAX(order_id) FROM orders";
		long results = jdbcTemplate.queryForObject(sqlSelectNextId, Long.class) + 1;
		return results;
	}
}
