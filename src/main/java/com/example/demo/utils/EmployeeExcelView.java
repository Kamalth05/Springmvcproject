package com.example.demo.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.example.demo.model.Employee;



public class EmployeeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=SPECS.xlsx");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("list");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("SPECIALIZATION");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("FIRSTNAME");
		row.createCell(2).setCellValue("COMPANY");
		row.createCell(3).setCellValue("GENDER");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("POST");
		row.createCell(6).setCellValue("AGE");
		row.createCell(7).setCellValue("COUNTRY");
		row.createCell(8).setCellValue("CITY");
		row.createCell(9).setCellValue("DEPARTMENT PHONE");
	}
	
	private void setBody(Sheet sheet, List<Employee> list) {
		int rowNum = 1;
		for(Employee spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getFname());
			row.createCell(2).setCellValue(spec.getCompany());
			row.createCell(3).setCellValue(spec.getGender());
			row.createCell(4).setCellValue(spec.getEmail());
			row.createCell(5).setCellValue(spec.getPost());
			row.createCell(6).setCellValue(spec.getAge());
			row.createCell(7).setCellValue(spec.getAddress().getCountry());
			row.createCell(8).setCellValue(spec.getAddress().getCity());
			row.createCell(9).setCellValue(spec.getDepartment().getDept_phone());
			
		}
	}

}
