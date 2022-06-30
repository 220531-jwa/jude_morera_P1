package dev.morera.controllers;

import java.util.List;

import dev.morera.models.Employee;
import dev.morera.models.Grade;
import dev.morera.models.Request;
import dev.morera.models.Status;
import dev.morera.repositories.EmployeeDAO;
import dev.morera.services.EmployeeService;
import dev.morera.services.RequestService;
import io.javalin.http.Context;

public class RequestController {

	private static RequestService rs;
	//private static EmployeeService es = new EmployeeService(new EmployeeDAO());


	public RequestController(RequestService rs) {
		RequestController.rs = rs;
	}

	public void getAllRequests(Context ctx) {
		Employee u = ctx.bodyAsClass(Employee.class); //we will perform manager check in service



		List<Request> reqs = rs.getAllRequests(u);
		if (!reqs.isEmpty() && reqs != null) {
			for (Request q : reqs) {
				System.out.println(q);
			}
			ctx.json(reqs);
			ctx.status(200);
		}
		else {
			ctx.status(404);
		}
	}

	public void getRequests(Context ctx) {

		Employee u = ctx.bodyAsClass(Employee.class);



		List<Request> reqs = rs.getRequestsByUser(u);
		if (!reqs.isEmpty() && reqs != null) {
			for (Request q : reqs) {
				System.out.println(q);
			}
			ctx.json(reqs);
			ctx.status(200);
		}
		else {
			ctx.status(404);
		}
	}

	public void newRequest(Context ctx) {		
		Request r = ctx.bodyAsClass(Request.class);
		if(rs.createNewRequest(r)) {
			ctx.status(200);
		}
		else {
			ctx.status(500);
		}



	}

	public void gradeRequest(Context ctx) {
		Grade g = ctx.bodyAsClass(Grade.class);
		System.out.println("into request: " + g);
		if (rs.gradeRequest(g)) {
			ctx.status(200);
		}
		else {
			ctx.status(404);
		}
	}
	
	public void changeStatus(Context ctx) {
		Status s = ctx.bodyAsClass(Status.class);
		if (rs.changeStatus(s)) {
			ctx.status(200);
		}
		else {
			ctx.status(404);
		}
	}

}
