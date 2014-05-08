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
//import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;


import com.jerseydemo.representation.Employeedetails;
import com.jerseydemo.services.Employeeservices;


@Path("employees")
public class Employeemanager {
	
	Employeedetails employeeDetail = new Employeedetails();
	Employeeservices employeeServices = new Employeeservices();
	String status ;
	
	@GET
	@Produces("text/html")
	public String list() {
		status = employeeServices.allEmployeedetails();
		return status;
	}
	
	@Path("/{employeeid}")
	@GET
	@Produces("text/html")
	public String find(@PathParam("employeeid") String employeeId){
		employeeDetail.setEmployeeId(employeeId);
		status = employeeServices.getEmployee(employeeDetail);
		return status;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   
	public String createnew(@FormParam("employeeid") String employeeId, @FormParam("employeename") String employeeName){
		employeeDetail.setEmployeeId(employeeId);
		employeeDetail.setEmployeeName(employeeName);
		status = employeeServices.addEmployee(employeeDetail);
		return status;
	}
	
   @Path("/{employeeid}")
   @PUT
   @Produces("text/html")
   public String update(@PathParam("employeeid") String employeeId, @FormParam("employeename") String employeeName) {
	   employeeDetail.setEmployeeId(employeeId);
	   employeeDetail.setEmployeeName(employeeName);
	   status = employeeServices.updateEmployee(employeeDetail);
	   return status;
	   
   }
   
   @Path("/{employeeid}")
   @DELETE
   @Produces("text/html")
   public String delete(@PathParam("employeeid") String employeeId){
	   employeeDetail.setEmployeeId(employeeId);
	   status = employeeServices.deleteEmployee(employeeDetail);
	   return status;
	   
   }
   
}