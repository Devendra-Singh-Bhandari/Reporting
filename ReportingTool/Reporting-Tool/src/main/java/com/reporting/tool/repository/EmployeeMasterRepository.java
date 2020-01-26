package com.reporting.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reporting.tool.entity.EmployeeMaster;

@Repository
public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Long>{

	@Query("SELECT em FROM EmployeeMaster em " + 
			"WHERE em.employeeId=( " + 
			"SELECT employee.employeeId " + 
			"FROM SalaryInfo s1 " + 
			"WHERE 3-1=(SELECT COUNT(DISTINCT salary) FROM SalaryInfo s2 " + 
			"WHERE s2.salary > s1.salary)) ")
	EmployeeMaster findByThirdHighestSalary();

}
