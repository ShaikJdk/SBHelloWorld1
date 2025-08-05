package com.spring.boot.service.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dbmodel.oracle.VersionO;
import com.spring.boot.repository.oracle.VersionEntityRepository;

@Service
public class VersionServiceO {

	@Autowired
	private VersionEntityRepository repo;

	@Transactional
	public VersionO putVersion(VersionO req) {
		VersionO v = repo.save(req);
		return v;
	}
	
	@Transactional
	public VersionO updateVersion(String vid, String vname) throws Exception{
	    VersionO version = repo.findById(vid)
	        .orElseThrow(() -> new RuntimeException("Version not found"));

	    version.setVname(vname);
	    version  = putVersion(version);
	    System.out.println(version);
	    return version;
	}
	
//	public void updateVersion(String vid, String vname) throws Exception{
//	    repo.updateVersionByVid(vid, vname);
//	}
	
}
