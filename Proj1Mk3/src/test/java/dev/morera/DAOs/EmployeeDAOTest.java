package dev.morera.DAOs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
import dev.morera.repositories.RequestDAO;
import dev.morera.utils.ConnectionUtility2;
import dev.morera.repositories.EmployeeDAO;

@ExtendWith(MockitoExtension.class)
public class EmployeeDAOTest{

	@InjectMocks
	EmployeeDAO ed;

	@Mock
	Connection mockConn;
	Statement mockState;

	@BeforeEach
	public void setupEach() {
		ed = new EmployeeDAO();
		//		cu = new ConnectionUtility2();
	}

	@Test
	public void GetEmployeeByUsername() throws SQLException {
		
		Employee mockEmployee = new Employee(4, false, "SampleName",
				"SamplePass", "Sample McSample");
		
		when(mockConn.createStatement()).thenReturn(mockState);
		when(mockConn.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
	  .executeQuery("");
		
			
	}
}