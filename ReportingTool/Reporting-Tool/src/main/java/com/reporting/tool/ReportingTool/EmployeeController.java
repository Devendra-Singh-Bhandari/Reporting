package com.reporting.tool.ReportingTool;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reporting.tool.dto.GenericResponse;
import com.reporting.tool.dto.MessageDto;
import com.reporting.tool.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/generate")
    public ResponseEntity<?> generateEmployeeData(@RequestParam(required = false) String generateType,HttpServletRequest request) {
		GenericResponse genericResponse = new GenericResponse();;
		MessageDto messageDto = new MessageDto();
		if(!StringUtils.isEmpty(generateType)) {
			messageDto.setMessage(employeeService.generateEmployeeReports(generateType));
		} else {
			messageDto.setMessage("Invalid Request. Please try again !!!");
		}
		genericResponse.setData(messageDto);
		return new ResponseEntity(genericResponse,HttpStatus.OK);
	}
	
}

