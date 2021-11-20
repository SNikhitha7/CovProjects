package com.cov.beans;

import java.util.ArrayList;
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

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Employee> employees = new ArrayList<>();

	public Department() {
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

	

	public Department(int id, String name) {
		super();
		this.id=id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", Name=" + name + "]";
	}

}
