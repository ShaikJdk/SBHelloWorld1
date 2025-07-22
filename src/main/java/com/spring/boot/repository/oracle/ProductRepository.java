//package com.spring.boot.repository.oracle;
//
//import java.math.BigDecimal;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.query.Param;
//
//import com.spring.boot.dbmodel.oracle.Product;
//
//public interface  ProductRepository extends JpaRepository<Product, String> {
//	
//	 @Procedure(name = "Product.getEmpDetails")
//	    void getEmpDetails(@Param("p_emp_id") Long empId,
//	                       @Param("p_name") OutputParameterHolder<String> name,
//	                       @Param("p_salary") OutputParameterHolder<BigDecimal> salary);
//}
