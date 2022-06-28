package dev.morera.controllers;

import dev.morera.models.Employee;
import dev.morera.services.EmployeeService;
import io.javalin.http.Context;

public class EmployeeController {



	private static EmployeeService es;



	public EmployeeController(EmployeeService es) {
		EmployeeController.es = es;

	}



	public  void loginEmployee(Context ctx){
		Employee u = ctx.bodyAsClass(Employee.class);
		Employee loggedIn = es.login(u.getUname(), u.getPword()); 
		//es.login(u.getUname(), u.getPword());

		if (loggedIn != null) {
			ctx.json(loggedIn);
			ctx.status(200);
		}
		else {
			ctx.status(404);
		}

	}


	public void loginManager(Context ctx) {
		Employee m = ctx.bodyAsClass(Employee.class);
		Employee loggedIn = es.loginManager(m.getUname(), m.getPword(), m.isFin_man());
		if (loggedIn != null) {
			ctx.json(loggedIn);
			ctx.status(200);
		}
		else {
			ctx.status(404);
		}

	}
}
