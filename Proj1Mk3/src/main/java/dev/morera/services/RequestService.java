package dev.morera.services;

import java.util.List;

import dev.morera.models.Employee;
import dev.morera.models.Grade;
import dev.morera.models.Request;
import dev.morera.models.Status;
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

	public boolean createNewRequest(Request r) {
		System.out.println(r);
		return (requestDAO.createNewRequest(r));


		//return null;
	}

	public List<Request> getAllRequests(Employee loggedIn) {
		if (loggedIn == null || !loggedIn.isFin_man()) {
			return null;}

		if (edao.getUserByUsername(loggedIn.getUname()) == null) {
			return null;
		}

		List<Request> reqs = requestDAO.getAllRequests();
		return reqs;


	}

	public boolean gradeRequest(Grade g) {
		Request found = requestDAO.getOneRequest(g.getReq_id());
		System.out.print("Service request returned:" + found);
		
		if (found != null && found.getStatus()==2) {
			Boolean n = requestDAO.gradeRequest(g);
			System.out.println("service returned bool: "+ n);
			return n;
		}
		
		
		return false;
	}

	public boolean changeStatus(Status s) {
		Request found = requestDAO.getOneRequest(s.getReq_id());
		
		if (found != null) {
			Boolean n = requestDAO.changeStatus(s);
			System.out.println("service returned bool: "+ n);
			return n;
		}		
		return false;
	}




}
