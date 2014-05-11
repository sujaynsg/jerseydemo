package com.jerseydemo.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.jerseydemo.representation.Employeedetails;

public class Employeeservices {

	public ArrayList<Employeedetails> allEmployeedetails(Connection connection) {

		ArrayList<Employeedetails> employees = new ArrayList();

		ResultSet rs = null;
		try {
			int flag = 0;
			Statement statement = connection.createStatement();
			String squery = "select * from employeeregister;";
			String status = "<h2>Employee List</h2>\n";
			rs = statement.executeQuery(squery);
			while (rs.next()) {
				Employeedetails employeeDetail = new Employeedetails();
				employeeDetail.setEmployeeId(rs.getString(1));
				employeeDetail.setEmployeeName(rs.getString(2));
				employees.add(employeeDetail);
			}
		} catch (SQLException sqle) {

		} catch (Exception e) {

		}
		return employees;

	}

	public Employeedetails getEmployee(Employeedetails employeeDetail,
			Connection connection) {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		try {
			String employeeId = employeeDetail.getEmployeeId();
			Statement statement = connection.createStatement();
			String squery = "select * from employeeregister where employeeid ='"
					+ employeeId + "';";
			rs = statement.executeQuery(squery);
			if (rs.next()) {
				/*
				 * return "<h2>Details of Employee # " + employeeId + " </h2><p><h3>Employee
				 * name: " + rs.getString(2) + "</h3>";
				 */
				employeeDetail.setEmployeeName(rs.getString(2));

			} else {
				employeeDetail.setEmployeeName("0");
			}

		} catch (SQLException sqle) {

		} catch (Exception e) {

		}
		return employeeDetail;

	}

	public Employeedetails addEmployee(Employeedetails employeeDetail,
			Connection connection) {
		// TODO Auto-generated method stub
		try {
			int flag = 0;
			String employeeId = employeeDetail.getEmployeeId();
			String employeeName = employeeDetail.getEmployeeName();
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select employeeid from employeeregister");
			while (rs.next()) {
				if (employeeId.equalsIgnoreCase(rs.getString(1))) {
					flag = 1;
				}
			}
			if (flag == 0) {
				String squery = "insert into employeeregister values('"
						+ employeeId + "', '" + employeeName + "');";
				int a = statement.executeUpdate(squery);
				return employeeDetail;
			} else {
				return employeeDetail;
			}

		} catch (SQLException sqle) {

		} catch (Exception e) {

		}
		return employeeDetail;
	}

	public Employeedetails updateEmployee(Employeedetails employeeDetail,
			Connection connection) {
		// TODO Auto-generated method stub

		try {
			String employeeId = employeeDetail.getEmployeeId();
			String employeeName = employeeDetail.getEmployeeName();
			;
			Statement statement = connection.createStatement();
			String squery = "update employeeregister set employeename = '"
					+ employeeName + "' where employeeid ='" + employeeId
					+ "';";
			int a = statement.executeUpdate(squery);

			if (a == 0) {

				return employeeDetail;
			} else {
				return employeeDetail;
			}

		} catch (SQLException sqle) {

		} catch (Exception e) {

		}
		return employeeDetail;

	}

	public Employeedetails deleteEmployee(Employeedetails employeeDetail,
			Connection connection) {

		try {
			employeeDetail = getEmployee(employeeDetail, connection);
			String employeeId = employeeDetail.getEmployeeId();
			Statement statement = connection.createStatement();
			String squery = "delete from employeeregister where employeeid ='"
					+ employeeId + "';";
			int a = statement.executeUpdate(squery);

		} catch (SQLException sqle) {

		} catch (Exception e) {
			System.out.println("Exception occured in Employeeserivce class");

		}
		return employeeDetail;

	}

}