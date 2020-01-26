package com.reporting.tool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salary_info")
public class SalaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private EmployeeMaster employee;

	@Column(name = "salary", nullable = false)
	private Float salary;

	public EmployeeMaster getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeMaster employee) {
		this.employee = employee;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
