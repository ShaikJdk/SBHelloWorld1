package com.spring.boot.service.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.boot.dbmodel.oracle.OrdersO;
import com.spring.boot.repository.oracle.OrderRepositoryO;
import com.zaxxer.hikari.HikariDataSource;

import oracle.jdbc.internal.OracleTypes;

@Service
public class OrderServiceO {

	@Autowired
	private OrderRepositoryO orderRepositoryO;

	@Autowired
	@Qualifier("dataSourceOracle")
    private HikariDataSource dataSource;
	
	public List<com.spring.boot.dbmodel.oracle.OrdersO> getAllOrders() {
		List<com.spring.boot.dbmodel.oracle.OrdersO> orders = orderRepositoryO.findAll();
		return orders;
	}
	
	public com.spring.boot.dbmodel.oracle.OrdersO createOrder(com.spring.boot.dbmodel.oracle.OrdersO req) {
		com.spring.boot.dbmodel.oracle.OrdersO order = orderRepositoryO.save(req);
		return order;
	}
	
	public List<OrdersO> getOrdersByType(String orderType) {
	    List<OrdersO> orders = new ArrayList<>();

	    try (Connection conn = dataSource.getConnection();
	         CallableStatement cs = conn.prepareCall("{ ? = call order_pkg.get_orders_by_type(?) }")) {

	        cs.registerOutParameter(1, OracleTypes.CURSOR);
	        cs.setString(2, orderType);
	        cs.execute();

	        try (ResultSet rs = (ResultSet) cs.getObject(1)) {
	            while (rs.next()) {
	                OrdersO order = new OrdersO(
	                    rs.getInt("ORDER_ID"),
	                    rs.getString("ORDER_NAME"),
	                    rs.getString("ORDER_TYPE"),
	                    rs.getDouble("ORDER_PRICE"),
	                    rs.getDate("DELIVARY_DATE").toLocalDate()
	                );
	                orders.add(order);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // Or use proper logging
	    }

	    return orders;
	}
}
