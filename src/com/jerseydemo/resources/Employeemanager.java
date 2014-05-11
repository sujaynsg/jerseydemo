package com.jerseydemo.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jerseydemo.representation.Employeedetails;
import com.jerseydemo.services.Employeeservices;
import com.jerseydemo.dao.JerseyDAOFactory;
import java.sql.Connection;
import java.util.ArrayList;

@Path("employees")
public class Employeemanager {

	Connection connection = JerseyDAOFactory.createconnection();

	Employeedetails employeeDetail = new Employeedetails();
	Employeeservices employeeServices = new Employeeservices();
	String status;
	ArrayList<Employeedetails> employees = new ArrayList();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Employeedetails> list() {
		employees = employeeServices.allEmployeedetails(connection);
		return employees;
	}

	@Path("/{employeeid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employeedetails find(@PathParam("employeeid")
	String employeeId) {
		employeeDetail.setEmployeeId(employeeId);
		employeeDetail = employeeServices.getEmployee(employeeDetail,
				connection);
		return employeeDetail;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Employeedetails createnew(@FormParam("employeeid")
	String employeeId, @FormParam("employeename")
	String employeeName) {
		employeeDetail.setEmployeeId(employeeId);
		employeeDetail.setEmployeeName(employeeName);
		employeeDetail = employeeServices.addEmployee(employeeDetail,
				connection);
		return employeeDetail;
	}

	@Path("/{employeeid}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Employeedetails update(@PathParam("employeeid")
	String employeeId, @FormParam("employeename")
	String employeeName) {
		employeeDetail.setEmployeeId(employeeId);
		employeeDetail.setEmployeeName(employeeName);
		employeeDetail = employeeServices.updateEmployee(employeeDetail,
				connection);
		return employeeDetail;

	}

	@Path("/{employeeid}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Employeedetails delete(@PathParam("employeeid")
	String employeeId) {
		employeeDetail.setEmployeeId(employeeId);
		employeeDetail = employeeServices.deleteEmployee(employeeDetail,
				connection);
		return employeeDetail;

	}

}