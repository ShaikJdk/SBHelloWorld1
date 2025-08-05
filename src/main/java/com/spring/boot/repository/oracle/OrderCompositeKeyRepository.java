package com.spring.boot.repository.oracle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.oracle.compositekey.OrderCompositeKeyEntitiyO;
import com.spring.boot.dbmodel.oracle.compositekey.OrderCompositeKeyIdO;

public interface OrderCompositeKeyRepository extends JpaRepository<OrderCompositeKeyEntitiyO, OrderCompositeKeyIdO> {
}
