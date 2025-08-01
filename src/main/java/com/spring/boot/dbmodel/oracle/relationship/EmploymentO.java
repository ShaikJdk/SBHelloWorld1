package com.spring.boot.dbmodel.oracle.relationship;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "EMPLOYMENT")
public class EmploymentO implements Serializable{

	public EmploymentO() {
		
	}
	private static final long serialVersionUID = 1L;
	
	public EmploymentO(Integer emptId, String emptName, Date joinDate, Date endDate, double experience,
			EmployeeO employee) {
		super();
		this.emptId = emptId;
		this.emptName = emptName;
		this.joinDate = joinDate;
		this.endDate = endDate;
		this.experience = experience;
		this.employee = employee;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "EMPT_ID")
	private Integer emptId;
	
	@Column(name ="EMPT_NAME")
	private String emptName;
	
	@Column(name = "JOINING_DATE")
	private Date joinDate;

	@Column(name ="RELEAVING_DATE")
	private Date endDate;
	
	@Column(name="EXPERIENCE")
	private double experience;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@JsonBackReference
	@JsonIgnore
	private EmployeeO employee;

	@Override
	public int hashCode() {
		return Objects.hash(emptId, emptName, endDate, experience, joinDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmploymentO other = (EmploymentO) obj;
		return Objects.equals(emptId, other.emptId) && Objects.equals(emptName, other.emptName)
				&& Objects.equals(endDate, other.endDate)
				&& Double.doubleToLongBits(experience) == Double.doubleToLongBits(other.experience)
				&& Objects.equals(joinDate, other.joinDate);
	}
	
}
