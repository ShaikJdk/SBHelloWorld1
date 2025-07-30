package com.spring.boot.repository.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.spring.boot.dbmodel.oracle.Product;

public interface  ProductRepository extends JpaRepository<Product, String> {
	
//	 @Procedure(name = "ProductPurchaseProcedure")
//	    void callPurchaseProcedure(
//	        @Param("ptype") String ptype,
//	        @Param("pquantity") Integer pquantity,
//	        @Param("ptnx_id") String ptnxId,
//	        @Param("pname") String pname,
//	        @Param("pdate") java.sql.Date pdate,
//	        @Param("pofferamt") Double pofferAmt
//	    );
}
