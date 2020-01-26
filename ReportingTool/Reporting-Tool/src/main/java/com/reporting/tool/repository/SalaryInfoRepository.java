package com.reporting.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reporting.tool.entity.EmployeeMaster;
import com.reporting.tool.entity.SalaryInfo;

@Repository
public interface SalaryInfoRepository extends JpaRepository<SalaryInfo, Long>{

	SalaryInfo findByEmployee(EmployeeMaster employeeMaster);

}
