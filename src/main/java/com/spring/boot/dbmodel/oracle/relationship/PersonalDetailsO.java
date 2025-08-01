package com.spring.boot.dbmodel.oracle.relationship;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="PERSONAL_DETAILS")
public class PersonalDetailsO implements Serializable {

	public PersonalDetailsO() {
		
	}
	
	public PersonalDetailsO(Integer id, String pancard, String passport, String aathour, EmployeeO employee) {
		super();
		this.id = id;
		this.pancard = pancard;
		this.passport = passport;
		this.aathour = aathour;
		this.employee = employee;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="PANCARD")
	private String pancard;
	
	@Column(name="PASSPORT")
	private String passport;
	
	@Column(name="AATHOUR")
	private String aathour;
	
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	@JsonBackReference
	@JsonIgnore
	private EmployeeO employee;

	@Override
	public int hashCode() {
		return Objects.hash(aathour, id, pancard, passport);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalDetailsO other = (PersonalDetailsO) obj;
		return Objects.equals(aathour, other.aathour) && Objects.equals(id, other.id)
				&& Objects.equals(pancard, other.pancard) && Objects.equals(passport, other.passport);
	}
	
	
	
}
