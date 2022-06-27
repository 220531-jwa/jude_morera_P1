package dev.morera.services;

import java.util.List;

import dev.morera.models.Employee;
import dev.morera.models.Request;
import dev.morera.repositories.EmployeeDAO;
import dev.morera.repositories.RequestDAO;

public class RequestService {

	private static RequestDAO requestDAO;
	
	public RequestService(RequestDAO rdao) {
		this.requestDAO = rdao;
	}
	
	private static EmployeeDAO edao = new EmployeeDAO();
	
	public List<Request> getRequestsByUser (Employee loggedIn){
		
		if (loggedIn == null) {
			return null;
		}
//		action = action.replaceAll("[{}\"\r\n ]", "");
		//String[] splited = action.split(":");
		
		
		
		Employee x = edao.getUserByUsername(loggedIn.getUname());
		
		if (x != null) {
			List<Request> reqs = requestDAO.getRequestsByUser(x.getE_id());
			
			
			
			return reqs;
		}
		return null;
		
		
		
		
		
		
		
	}
	
	
}
