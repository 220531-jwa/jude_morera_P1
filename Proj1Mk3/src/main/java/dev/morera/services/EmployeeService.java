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
	
	public Employee loginManager(String uname, String pword, boolean fin_man) {
		
		Employee pwordCheck = login( uname, pword);
		if (pwordCheck != null) {
			if (pwordCheck.isFin_man()) {
				return pwordCheck;
			}
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
}
