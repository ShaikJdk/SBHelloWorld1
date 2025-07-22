package com.spring.boot.service.mysql.tnx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Tnx;
import com.spring.boot.repository.mysql.Tnx2Repository;

@Service
public class Tnx2Service {
	
	@Autowired
	private Tnx2Repository tnx2Repository;

	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = {}, noRollbackFor = {BusinessException.class})
	public void updateTnx2(Tnx tnx) throws BusinessException{
		try {
			tnx2Repository.updateTnx2(tnx.getTnxId(), Integer.parseInt(tnx.getTnx2Val()));
		} catch(Exception e) {
			throw new BusinessException(e.getMessage());	
		}

	}

}
