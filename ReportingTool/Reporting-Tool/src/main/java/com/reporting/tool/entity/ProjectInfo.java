package com.reporting.tool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_info")
public class ProjectInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id", nullable = false, unique = true)
	private Long projectId;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@Column(name = "project_manager_id", nullable = false)
	private String projectManagerId;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectManagerId() {
		return projectManagerId;
	}

	public void setProjectManagerId(String projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
