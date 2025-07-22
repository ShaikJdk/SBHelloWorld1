package com.spring.boot.service.mysql.tnx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Tnx;
import com.spring.boot.repository.mysql.Tnx1Repository;

@Service
public class Tnx1Service {

	@Autowired
	private Tnx1Repository tnx1Repository;
	
	@Autowired
	private Tnx2Service tnx2Service;

	@Transactional
	public void updateAllTnxs(Tnx tnx) throws BusinessException
	{
		tnx1Repository.updateTnx1(tnx.getTnxId(), Integer.parseInt(tnx.getTnx1Val()));
		tnx2Service.updateTnx2(tnx);
	}

}
