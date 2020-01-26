package com.reporting.tool.dto;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reporting.tool.entity.EmployeeMaster;

public class ExcelWriter {

	public static void generateExcel(EmployeeMaster employeeMaster, Float salary) {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet spreadsheet = workbook.createSheet("Salary_Sheet");

		XSSFRow row;
		Cell cell;
		row = spreadsheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Employee Name");

		cell = row.createCell(1);
		cell.setCellValue("Department Name");

		cell = row.createCell(2);
		cell.setCellValue("Salary");

		row = spreadsheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue(employeeMaster.getEmployeeName());

		cell = row.createCell(1);
		cell.setCellValue(employeeMaster.getDepartment().getDepartmentName());

		cell = row.createCell(2);
		cell.setCellValue(salary);

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File("/home/nykaa/Desktop/ReportingTool/Salary_Sheet.xlsx"));
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Salary_Sheet.xlsx written successfully");

	}
}
