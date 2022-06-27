package dev.morera.javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

import dev.morera.controllers.EmployeeController;
import dev.morera.controllers.RequestController;
import dev.morera.repositories.EmployeeDAO;
import dev.morera.repositories.RequestDAO;
import dev.morera.services.EmployeeService;
import dev.morera.services.RequestService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


public class JavalinRunnerP1 {

	public static void main(String[] args) {
		EmployeeController ec = new EmployeeController(new EmployeeService(new EmployeeDAO()));
		RequestController rc = new RequestController(new RequestService(new RequestDAO()));
				Javalin app = Javalin.create(config -> {
		config.enableCorsForAllOrigins();
	//	config.enableCorsForOrigin("http://localhost:8081");
	//	config.addStaticFiles("/public", Location.CLASSPATH);
		});
		app.start(8081);

		app.routes(()->{
			path("/login", () ->{
				put(ec::loginEmployee);
			});
			path("/requests", ()->{
				post(rc::getRequests);
			});
		});
	}
}
