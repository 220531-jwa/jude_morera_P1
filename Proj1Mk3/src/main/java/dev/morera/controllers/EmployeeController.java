package dev.morera.controllers;

import dev.morera.models.Employee;
import dev.morera.services.EmployeeService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeController {

	private static Logger log = LogManager.getLogger(EmployeeController.class);

	private static EmployeeService es;



	public EmployeeController(EmployeeService es) {
		EmployeeController.es = es;

	}



	public  void loginEmployee(Context ctx){
		Employee u = ctx.bodyAsClass(Employee.class);
		log.info("logging in as employee: " + u);
		
		Employee loggedIn = es.login(u.getUname(), u.getPword()); 
		

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
		log.info("logging in as manager: " + m);
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
