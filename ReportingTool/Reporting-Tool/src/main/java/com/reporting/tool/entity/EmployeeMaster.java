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
@Table(name = "employee_master")
public class EmployeeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", nullable = false, unique = true)
	private Long employeeId;

	@Column(name = "employee_name", nullable = false)
	private String employeeName;

	@Column(name = "designation", nullable = false)
	private String designation;

	@Column(name = "contact_number", nullable = false)
	private String contactNumber;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "reporting_officer_id", nullable = false)
	private Long reportingOfficerId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private ProjectInfo project;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private DepartmentInfo department;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getReportingOfficerId() {
		return reportingOfficerId;
	}

	public void setReportingOfficerId(Long reportingOfficerId) {
		this.reportingOfficerId = reportingOfficerId;
	}

	public ProjectInfo getProject() {
		return project;
	}

	public void setProject(ProjectInfo project) {
		this.project = project;
	}

	public DepartmentInfo getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentInfo department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
