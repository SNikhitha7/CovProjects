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
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String Name;
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> employees;

	public Department() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setDeptName(String Name) {
		this.Name = Name;
	}

	public Department(int id, String Name) {
		super();
		this.id = id;
		this.Name = Name;

	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", Name=" + Name + "]";
	}

}
