package com.spring.boot.service.oracle;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.boot.pojo.PurchaseDetails;
import com.spring.boot.repository.oracle.PurchaseDetailsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class PurchaseServiceO {

	
	@Autowired
	private PurchaseDetailsRepository purchaseDetailsRepository;
	
	@PersistenceContext(unitName = "oracle")
	@Qualifier("oracleEntityManagerFactory")
    private EntityManager oracleEntityManager;

	public PurchaseDetails getPurchesDetails(String ptype, int pquantity) {
        StoredProcedureQuery query = oracleEntityManager
            .createStoredProcedureQuery("procedure_purchase1")
            .registerStoredProcedureParameter("ptype", String.class, ParameterMode.IN)
            .registerStoredProcedureParameter("pquantity", Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter("ptnx_id", String.class, ParameterMode.OUT)
            .registerStoredProcedureParameter("pname", String.class, ParameterMode.OUT)
            .registerStoredProcedureParameter("pdate", java.sql.Date.class, ParameterMode.OUT)
            .registerStoredProcedureParameter("pofferamt", Double.class, ParameterMode.OUT)
            .setParameter("ptype", ptype)
            .setParameter("pquantity", pquantity);

        query.execute();

        String tnxid = (String) query.getOutputParameterValue("ptnx_id");
        String pname = (String) query.getOutputParameterValue("pname");
        Date dateOfTnx = (Date) query.getOutputParameterValue("pdate");
        Double finalOfferAmt = (Double) query.getOutputParameterValue("pofferamt");

        return PurchaseDetails.builder().tnx_id(tnxid).pname(pname).pdate(dateOfTnx).offeramt(finalOfferAmt).build();
    }
	
	public com.spring.boot.dbmodel.oracle.PurchaseDetails getPurchaseDetailsO(String tnxId, String tnxType) {
		Optional<com.spring.boot.dbmodel.oracle.PurchaseDetails> purchaseDetails= purchaseDetailsRepository.findByTnxIdAndTnxType(tnxId, tnxType);
		return purchaseDetails.get();
	
	}
}
