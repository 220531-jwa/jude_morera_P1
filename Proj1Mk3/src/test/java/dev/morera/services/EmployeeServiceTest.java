package dev.morera.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.morera.models.Employee;
import dev.morera.repositories.EmployeeDAO;


////@IncludeTags("UnitTest")
//@Suite
//@SelectPackages("dev.morera.services")
//@ExcludeTags("Cuc")
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
	@Tag("UnitTest")
	public void loginValid() {
		Employee mockEmployee = new Employee(4, false, "SampleName",
				"SamplePass", "Sample McSample");
		
		when(eDaoMock.getUserByUsername(anyString())).thenReturn(mockEmployee);
		
		Employee loggedIn = empService.login("SampleName", "SamplePass");
		
		assertEquals (mockEmployee, loggedIn);
		
	}
	
	@Test
	@Tag("UnitTest")
	public void loginInvalidUserIsNull() {
//		Employee mockEmployee = new Employee(4, false, "SampleName",
//				"SamplePass", "Sample McSample");
		
		when(eDaoMock.getUserByUsername(anyString())).thenReturn(null);
		
		Employee loggedIn = empService.login("WrongName", "SamplePass");
		
		assertEquals (null, loggedIn);
		
	}
	
	@Test
	public void loginInvalidPasswordNull() {
	
		Employee mockEmployee = new Employee(4, false, "SampleName",
				"SamplePass", "Sample McSample");
		
		when(eDaoMock.getUserByUsername(anyString())).thenReturn(mockEmployee);
		
		Employee loggedIn = empService.login("SampleName", "WRONG");
		
		assertEquals(null, loggedIn);
			
	}
	
	//////////////////////////////////managers below
	
	@Test 
	public void loginValidManager() {
		Employee mockManager = new Employee(4, true, "SampleName",
				"SamplePass", "Sample McSample");
		when(eDaoMock.getUserByUsername(anyString())).thenReturn(mockManager);
		
		Employee loggedIn = empService.loginManager("SampleName", "SamplePass", true);
		
		assertEquals(mockManager,loggedIn);
		
	}
	
	@Test
	public void loginValidNonManagerNull() {
		
//		Employee mockManager = new Employee(4, true, "SampleName",
//				"SamplePass", "Sample McSample");
		/*
		 * Because the null check happens *before* the DAO is even addressed
		 * (thus returning null without using the dao), including the mock dao was
		 *  too much stub
		 */
//		when(eDaoMock.getUserByUsername(anyString())).thenReturn(mockManager);
		
		Employee loggedIn = empService.loginManager("SampleName", "SamplePass", false);
		
		assertEquals(null,loggedIn); 
		
	}
	//these next two should be easy, as the managerLogin method calls the non-manager login first
	@Test
	public void loginInvalidUserManagerNull() {
		
//		Employee mockManager = new Employee(4, true, "SampleName",
//				"SamplePass", "Sample McSample");
		when(eDaoMock.getUserByUsername(anyString())).thenReturn(null);
		
		Employee loggedIn = empService.loginManager("You're Mom", "SamplePass", true);
		
		assertEquals(null,loggedIn);
		
	}
	
	@Test
	public void loginInvalidPassManagerNull() {
		
//		Employee mockManager = new Employee(4, true, "SampleName",
//				"SamplePass", "Sample McSample");
		when(eDaoMock.getUserByUsername(anyString())).thenReturn(null);
		
		Employee loggedIn = empService.loginManager("SampleName", "You're Dad", true);
		
		assertEquals(null,loggedIn);
	
	}
}
