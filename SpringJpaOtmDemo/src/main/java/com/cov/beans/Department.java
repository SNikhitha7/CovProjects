package com.cov.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String deptName;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department() {
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Department(long id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
		
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}
	

}
