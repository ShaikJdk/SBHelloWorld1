package com.spring.boot.dbmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "journaling")
@Getter
@Setter
public class Journaling {

	public Journaling(String journalingId, String journaldata) {
		super();
		this.journalingId = journalingId;
		this.journaldata = journaldata;
	}

	public Journaling() {
		super();
	}

	@Column(name = "JOURNALING_ID")
    @Id
	private String journalingId;
	
	@Column(name = "JOURNALING_DATA", nullable = false, length = 2000)
	private String journaldata;
		
}
