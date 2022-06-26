package dev.morera.services;

import dev.morera.models.Employee;
import dev.morera.repositories.EmployeeDAO;

public class EmployeeService {

	private static EmployeeDAO employeeDAO;
	
	public EmployeeService(EmployeeDAO edao) {
		this.employeeDAO = edao;
	}

	public Employee login(String uname, String pword) {
		
		Employee e = employeeDAO.getUserByUsername(uname);
		
		if (e.getPword().equals(pword)) {
			return e;
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
}
