package com.spring.boot.dbmodel.oracle.relationship;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@Entity
@Table(name = "SKILS")
public class SkilsO implements Serializable{

	public SkilsO() {
		
	}
	
	
	public SkilsO(Integer skilId, String skilName, double skilExp, List<EmployeeO> empList) {
		super();
		this.skilId = skilId;
		this.skilName = skilName;
		this.skilExp = skilExp;
		this.empList = empList;
	}


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SKIL_ID")
	private Integer skilId;
	
	@Column(name="SKIL_NAME")
	private String skilName;

	@Column(name="SKIL_EXPERIENCE")
	private double skilExp;
	
	@ManyToMany(fetch= FetchType.LAZY, mappedBy = "skils")
	@JsonBackReference
	@JsonIgnore
	List<EmployeeO> empList;

	@Override
	public int hashCode() {
		return Objects.hash(skilExp, skilId, skilName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkilsO other = (SkilsO) obj;
		return Double.doubleToLongBits(skilExp) == Double.doubleToLongBits(other.skilExp)
				&& Objects.equals(skilId, other.skilId) && Objects.equals(skilName, other.skilName);
	}

	
}
