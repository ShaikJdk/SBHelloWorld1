package com.spring.boot.service.oracle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dbmodel.oracle.relationship.EmployeeO;
import com.spring.boot.dbmodel.oracle.relationship.EmploymentO;
import com.spring.boot.dbmodel.oracle.relationship.PersonalDetailsO;
import com.spring.boot.dbmodel.oracle.relationship.SkilsO;
import com.spring.boot.repository.oracle.EmployeeRepository;

@Service
public class EmployeeServiceO {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public EmployeeO saveEmployee(EmployeeO emp) {

		EmployeeO empR = new EmployeeO();
		PersonalDetailsO pdoR = new PersonalDetailsO();
		Set<EmploymentO> emptSet = new HashSet<>();
		emp.getEmployment().stream().forEach(em -> {
			EmploymentO emR1 = new EmploymentO();
			emR1.setEmptId(em.getEmptId());
			emR1.setEmptName(em.getEmptName());
			emR1.setJoinDate(em.getJoinDate());
			emR1.setExperience(em.getExperience());
			emR1.setEndDate(em.getEndDate());
			emR1.setEmployee(empR);
			emptSet.add(emR1);
		});
		
		SkilsO skR1 = new SkilsO();
		SkilsO skR2 = new SkilsO();
		
		skR1.setSkilId(emp.getSkils().get(0).getSkilId());
		skR1.setSkilName(emp.getSkils().get(0).getSkilName());
		skR1.setSkilExp(emp.getSkils().get(0).getSkilExp());
		skR1.setEmpList(new ArrayList<EmployeeO>());
		
		skR2.setSkilId(emp.getSkils().get(1).getSkilId());
		skR2.setSkilName(emp.getSkils().get(1).getSkilName());
		skR2.setSkilExp(emp.getSkils().get(1).getSkilExp());
		skR2.setEmpList(new ArrayList<EmployeeO>());
		List<SkilsO> skils = new ArrayList<>(); skils.add(skR1); skils.add(skR2);
		
		pdoR.setAathour(emp.getPersonalDetails().getAathour());
		pdoR.setPancard(emp.getPersonalDetails().getPancard());
		pdoR.setAathour(emp.getPersonalDetails().getPassport());
		pdoR.setEmployee(empR);

		empR.setEname(emp.getEname());	
		empR.setPersonalDetails(pdoR);
		empR.setEmployment(emptSet);
		empR.setSkils(skils);
//		EmployeeO existing = employeeRepository.findById(emp.getEid()).orElseThrow();
//		BeanUtils.copyProperties(emp, existing, "eid", "version");
		EmployeeO empRes = employeeRepository.save(empR);
		return empRes;
	}
	
	 @Transactional
	public EmployeeO getEmployee(Integer empId) {
//		EmployeeO empRes = employeeRepository.findByEid(empId);
//		return empRes;
		 Optional<EmployeeO> employee = employeeRepository.findById(empId);

			    return employee.get();
	}
	 @Transactional
	public List<EmployeeO> getEmployees() {
		List<EmployeeO> empRes = employeeRepository.findAll();
		return empRes;
	}
}
