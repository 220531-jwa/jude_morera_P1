package dev.morera.controllers;

import java.util.List;

import dev.morera.models.Employee;
import dev.morera.models.Request;
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
	
}
