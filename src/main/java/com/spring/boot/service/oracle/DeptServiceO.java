package com.spring.boot.service.oracle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.repository.oracle.DeptRepositoryO;

@Service
public class DeptServiceO {

	@Autowired
	private DeptRepositoryO deptRepositoryO;

	public List<com.spring.boot.dbmodel.oracle.DeptO> getAllDepts() {
		List<com.spring.boot.dbmodel.oracle.DeptO> depts = deptRepositoryO.findAll();
		return depts;
	}
}
