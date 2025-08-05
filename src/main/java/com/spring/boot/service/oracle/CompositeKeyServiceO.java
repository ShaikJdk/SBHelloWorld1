package com.spring.boot.service.oracle;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dbmodel.oracle.compositekey.OrderCompositeKeyDelivaryAddressO;
import com.spring.boot.dbmodel.oracle.compositekey.OrderCompositeKeyEntitiyO;
import com.spring.boot.dbmodel.oracle.compositekey.OrderCompositeKeyIdO;
import com.spring.boot.repository.oracle.OrderCompositeKeyRepository;

@Service
public class CompositeKeyServiceO {

	@Autowired
	private OrderCompositeKeyRepository repo;


	 public OrderCompositeKeyEntitiyO saveOrder(OrderCompositeKeyEntitiyO ord) {
	        OrderCompositeKeyIdO id = new OrderCompositeKeyIdO(ord.getId().getOrderId(), ord.getOrderName());
	        OrderCompositeKeyDelivaryAddressO address = 
	        		new OrderCompositeKeyDelivaryAddressO(ord.getAddress().getAdd1(),
	        				ord.getAddress().getDistrict(), ord.getAddress().getState(),ord.getAddress().getPincode());

	        OrderCompositeKeyEntitiyO entity = new OrderCompositeKeyEntitiyO(
	                id, ord.getOrderName(), ord.getOrderType(),ord.getPrice(), ord.getDelivaryDate(), address);

	        OrderCompositeKeyEntitiyO result = repo.save(entity);
	        return result;
	    }
	 
	 public OrderCompositeKeyEntitiyO findOrderById(int oid, String oname) {
	        OrderCompositeKeyIdO id = new OrderCompositeKeyIdO(oid, oname);

	        Optional<OrderCompositeKeyEntitiyO> result = repo.findById(id);
	       return result.get();
	    }
	 
	
}
