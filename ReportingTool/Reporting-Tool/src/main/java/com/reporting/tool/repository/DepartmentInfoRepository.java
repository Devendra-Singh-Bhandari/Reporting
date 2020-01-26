package com.reporting.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reporting.tool.entity.DepartmentInfo;

@Repository
public interface DepartmentInfoRepository extends JpaRepository<DepartmentInfo, Long>{

	DepartmentInfo findByDepartmentId(Long departmentId);

}
