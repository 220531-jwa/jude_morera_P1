package dev.morera.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.morera.models.Employee;
import dev.morera.models.Request;
import dev.morera.models.Status;
import dev.morera.repositories.EmployeeDAO;
import dev.morera.repositories.RequestDAO;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {

	@InjectMocks
	RequestService rServ;
	
	@Mock
	RequestDAO rDaoMock;
	EmployeeDAO eDaoMock;
	
	@BeforeEach
	public void setupEach() {
		rServ = new RequestService(rDaoMock);
		eDaoMock = new EmployeeDAO();
	}
	
	@Test
	public void getRequestsByValidUser() {
		
		Employee mockEmployee = new Employee(4, false, "SampleName",
				"SamplePass", "Sample McSample");
		
		
		List<Request> mockRList = new ArrayList<Request>();
		
		
		Request mockRequest = new Request(1, 4, 0.0, 1,10.0,.50,
				Timestamp.valueOf("2011-05-11 13:30:00.000"),"A place","an event","reason", 1, "");
		mockRList.add(mockRequest);
		
		when(eDaoMock.getUserByUsername(anyString()))
		.thenReturn(mockEmployee);
			
		when(rDaoMock.getRequestsByUser(anyInt()))
		.thenReturn(mockRList);

		
		List<Request> returned = rServ.getRequestsByUser(mockEmployee);
		
		
		assertEquals (mockRList.get(0), returned.get(0));
		
	}
	
	@Test
	public void changeStatusValid() {
		
		Status mockStatus=new Status(1, 2);
		
		when(rDaoMock.getOneRequest(anyInt())).thenReturn(new Request());
		
		when(rDaoMock.changeStatus(mockStatus)).thenReturn(true);
		
		Boolean worked = rServ.changeStatus(mockStatus);
		assertEquals(true, worked);
	}
	
	@Test
	public void changeStatusInvalidNull() {
		
Status mockStatus=new Status(1, 2);
		
		when(rDaoMock.getOneRequest(anyInt())).thenReturn(new Request());
		
		when(rDaoMock.changeStatus(mockStatus)).thenReturn(false);
		
		Boolean worked = rServ.changeStatus(mockStatus);
		assertEquals(false, worked);
		
	}
	
	
	
	
	
	
	
	
}
