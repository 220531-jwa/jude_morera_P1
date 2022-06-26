package dev.morera.services;

import java.util.List;

import dev.morera.models.Request;
import dev.morera.repositories.RequestDAO;

public class RequestService {

	private static RequestDAO requestDAO;
	
	public RequestService(RequestDAO rdao) {
		this.requestDAO = rdao;
	}
	
	public List<Request> getRequestsByUser (String uname){
		
		List<Request> reqs = requestDAO.getRequestsByUser(uname);
		
		
		
		return reqs;
		
	}
	
	
}
