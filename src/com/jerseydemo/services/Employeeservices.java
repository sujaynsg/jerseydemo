package com.jerseydemo.services;
import java.util.Map;
import java.util.TreeMap;

import com.jerseydemo.representation.Employeedetails;

public class Employeeservices {
	public static Map<String, String> employeeRegister = new TreeMap<String, String>();
	
	public String addEmployee (Employeedetails employeedetail) {
		
		String employeeId = employeedetail.getEmployeeId();
		String employeeName = employeedetail.getEmployeeName();
		employeeRegister.put(employeeId, employeeName);
	    return "<h2>Added Emp # " + employeeName+"<h2>";
		
	}
	
	public String updateEmployee (Employeedetails employeedetail) {
		
		String employeeId = employeedetail.getEmployeeId();
		String employeeName = employeedetail.getEmployeeName();
		if (employeeRegister.containsKey(employeeId)) {
			employeeRegister.put(employeeId, employeeName);
			return "<h2>Update Emp #" + employeeId + " name as " +employeeName+"</h2>";
		}
		else
			return "No such data!!!";
		
	}
	
	public String getEmployee (Employeedetails employeedetail) {
		
		String employeeId = employeedetail.getEmployeeId();
		if (employeeRegister.containsKey(employeeId)) {
			return "<h2>Details of Employee # " + employeeId + " </h2><p>Employee name: " + employeeRegister.get(employeeId);
		}
		else
			return "No such data!!!";
	}
	
	public String deleteEmployee (Employeedetails employeedetail) {
		
		String employeeId = employeedetail.getEmployeeId();
		if (employeeRegister.containsKey(employeeId)) {
			employeeRegister.remove(employeeId);
			return "<h2>Details of Employee # " + employeeId + "is deleted";
		}
		else
			return "No such data!!!";
	}
	
	public String allEmployeedetails () {
		
		String status = "<h2>Employee List</h2>\n";
		for (Map.Entry<String, String> employee : employeeRegister.entrySet())
			status +=   employee.getKey() + " - " + employee.getValue() + "\n";
		return status;
	      
	}
	
	
}
