package com.spring.boot.dbmodel.oracle.relationship;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Builder;
import lombok.Data;

/*
 * Cascade - what ever changes done on main table those changes will be done on its relational table (or) not
 * 	CascadeType.PERSIST : cascade type presist means that save() or persist() operations cascade to related entities.
		CascadeType.MERGE : cascade type merge means that related entities are merged when the owning entity is merged.
		CascadeType.REFRESH : cascade type refresh does the same thing for the refresh() operation.
		CascadeType.REMOVE : cascade type remove removes all related entities association with this setting when the owning entity is deleted.
		CascadeType.DETACH : cascade type detach detaches all related entities if a “manual detach” occurs.
		CascadeType.ALL : cascade type all is shorthand for all of the above cascade operations.
		
		Example:-
		@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
		@JoinColumn(name="EMPLOYEE_ID")
		private Set<Employment> employment;
		Now only when save() or persist() methods are called using employee instance then only Employment will be persisted.
		 If any other method is called on session, it’s effect will not affect/cascade to Employment .
 */

@Data
@Builder
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeO implements Serializable{

	public EmployeeO() {
		
	}

	public EmployeeO(Integer eid, String ename, Integer version, PersonalDetailsO personalDetails,
			Set<EmploymentO> employment, List<SkilsO> skils) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.version = version;
		this.personalDetails = personalDetails;
		this.employment = employment;
		this.skils = skils;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="EID")
	private Integer eid;
	
	@Column(name="ENAME")
	private String ename;
	
	@Version
	@Column(name = "VERSION")
	private Integer version = 0; 
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy ="employee", fetch = FetchType.EAGER)
	@JsonManagedReference
	private PersonalDetailsO personalDetails;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee",fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<EmploymentO> employment;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonManagedReference
	@JoinTable(name="EMPLOYEE_SKILS",
							joinColumns = {@JoinColumn(name="EID")},
							inverseJoinColumns = {@JoinColumn(name="SKIL_ID")})
	private List<SkilsO> skils;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(eid, ename);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeO other = (EmployeeO) obj;
		return Objects.equals(eid, other.eid) && Objects.equals(ename, other.ename);
	}
	
	
}
