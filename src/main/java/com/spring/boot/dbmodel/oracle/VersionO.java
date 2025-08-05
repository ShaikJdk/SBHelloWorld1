package com.spring.boot.dbmodel.oracle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@Table(name = "VERSION_EXP")
public class VersionO {

	public VersionO() {
	}
	
	public VersionO(String vid, String vname, Integer version) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.version = version;
	}

	@Id
	@Column(name = "VID", nullable = false)
	private String vid;
	
	@Column(name = "VNAME")
	private String vname;
	
    @Version
    @Column(name = "VERSION")
    private Integer version;

}
