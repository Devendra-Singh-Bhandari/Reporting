package com.reporting.tool.serviceImpl;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.tool.constants.Constants;
import com.reporting.tool.dto.ExcelWriter;
import com.reporting.tool.entity.DepartmentInfo;
import com.reporting.tool.entity.EmployeeMaster;
import com.reporting.tool.entity.SalaryInfo;
import com.reporting.tool.repository.DepartmentInfoRepository;
import com.reporting.tool.repository.EmployeeMasterRepository;
import com.reporting.tool.repository.SalaryInfoRepository;
import com.reporting.tool.service.EmployeeService;
import org.w3c.dom.Document; 

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private DepartmentInfoRepository departmentInfoRepository;
	
	@Autowired
	EmployeeMasterRepository employeeMasterRepository;
	
	@Autowired
	SalaryInfoRepository salaryInfoRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public String generateEmployeeReports(String generateType) {
		System.out.println("generateType:::"+generateType);
		String message = "";
		switch (generateType) {
		case Constants.GENERATE_SALARY:
			message = generateSalaryReport();
			break;
		case Constants.EFFECTIVE_IN_TIME:
			message = generateInOutTimeReport();
			break;
		default:
			message = Constants.MESSAGE;
		}
		return message;
	}

	private String generateInOutTimeReport() {
		DepartmentInfo departmentInfo = departmentInfoRepository.findByDepartmentId(1L);
		System.out.println("*******************************************");
		System.out.println(departmentInfo.getDepartmentName());
		System.out.println("*******************************************");
		return null;

	}

	private String generateSalaryReport() {
		String query = loadFile();
		EmployeeMaster employeeMaster = (EmployeeMaster) entityManager.createNativeQuery(query, EmployeeMaster.class).getSingleResult();
		SalaryInfo salaryInfo = salaryInfoRepository.findByEmployee(employeeMaster);
		ExcelWriter.generateExcel(employeeMaster,salaryInfo.getSalary());
		return Constants.GENERATE_MESSAGE;
	}

	private String loadFile() {
		try {
			File file = new File("src/main/resources/generateSalary.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			return doc.getElementsByTagName("SQL").item(0).getTextContent();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
