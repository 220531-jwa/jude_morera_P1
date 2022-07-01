package dev.morera.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.morera.models.Employee;
import dev.morera.repositories.EmployeeDAO;



@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService empService;
	
	@Mock
	EmployeeDAO eDaoMock;
	
	@BeforeEach
	public void setupEach() {
		empService = new EmployeeService(eDaoMock);
	}
	
	@Test
	public void loginValid() {
		Employee mockEmployee = new Employee(4, false, "SampleName",
				"SamplePass", "Sample McSample");
		
		when(eDaoMock.getUserByUsername(anyString())).thenReturn(mockEmployee);
		
		Employee loggedIn = empService.login("SampleName", "SamplePass");
		
		assertEquals (mockEmployee, loggedIn);
		
	}
	
	
	
}
