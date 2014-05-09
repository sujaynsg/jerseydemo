package com.jerseydemo.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import com.jerseydemo.representation.Employeedetails;

public class Employeeservices {

	public String allEmployeedetails(Connection connection) {

		ResultSet rs = null;
		try {
			int flag = 0;
			Statement statement = connection.createStatement();
			String squery = "select * from employeeregister;";
			String status = "<h2>Employee List</h2>\n";
			rs = statement.executeQuery(squery);
			while (rs.next()) {
				flag = 1;
				status += "<h5>" + rs.getString(1) + " - " + rs.getString(2)
						+ "</h5>";
				status += "\n";
			}

			if (flag == 0) {
				return "<h3>No data are avaliable!!!</h3>";
			} else {
				return status;
			}

		} catch (SQLException sqle) {
			return "Error Occured";
		} catch (Exception e) {
			return "Error Occured";
		}

	}

	public String getEmployee(Employeedetails employeeDetail,
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
				return "<h2>Details of Employee # " + employeeId
						+ " </h2><p><h3>Employee name: " + rs.getString(2)
						+ "</h3>";
			} else {
				return "<h3>No such data!!!</h3>";
			}

		} catch (SQLException sqle) {
			return "Error Occured";
		} catch (Exception e) {
			return "Error Occured";
		}

	}

	public String addEmployee(Employeedetails employeeDetail,
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
				return "<h2>Added Emp # " + employeeName + "<h2>";
			} else {
				return "<h3> Emp # " + employeeId + "is already present </h3>";
			}

		} catch (SQLException sqle) {
			return "Error Occured";
		} catch (Exception e) {
			return "Error Occured";
		}
	}

	public String updateEmployee(Employeedetails employeeDetail,
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

				return "<h3>No such data!!!</h3>";
			} else {
				return "<h2>Update Emp #" + employeeId + " name as "
						+ employeeName + "</h2>";
			}

		} catch (SQLException sqle) {
			return "Error Occured";
		} catch (Exception e) {
			return "Error Occured";
		}

	}

	public String deleteEmployee(Employeedetails employeeDetail,
			Connection connection) {

		try {
			String employeeId = employeeDetail.getEmployeeId();
			Statement statement = connection.createStatement();
			String squery = "delete from employeeregister where employeeid ='"
					+ employeeId + "';";
			int a = statement.executeUpdate(squery);

			if (a == 0) {
				return "<h3>No such data!!!</h3>";
			} else {
				return "<h2>Details of Employee # " + employeeId + "is deleted";
			}

		} catch (SQLException sqle) {
			return "Error Occured";
		} catch (Exception e) {
			System.out.println("Exception occured in Employeeserivce class");
			return "Error Occured";
		}

	}

}
