package com.cov.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String deptname;
	long deptno;
	@ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    
    private Department department;

    public Employee() {
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public long getDeptno() {
		return deptno;
	}
	public void setDeptno(long deptno) {
		this.deptno = deptno;
	}
	public Employee(int id, String name, String deptname, long deptno) {
		super();
		this.id = id;
		this.name = name;
		this.deptname = deptname;
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptname=" + deptname + ", deptno=" + deptno + "]";
	}
	
	

}
