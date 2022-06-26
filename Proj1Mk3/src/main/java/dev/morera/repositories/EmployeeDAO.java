package dev.morera.repositories;

//import java.sql.SQLException;
import java.sql.*;


import dev.morera.models.Employee;
import dev.morera.utils.ConnectionUtility;

public class EmployeeDAO {

	//static?
	private   ConnectionUtility cu = ConnectionUtility.getConnectionUtility();

	public Employee getUserByUsername(String uname) {

		String sql = "select * from project1.employees where uname = ?";

		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(
						rs.getInt("e_id"),
						rs.getBoolean("fin_man"),
						rs.getString("uname"),
						rs.getString("pword"),
						rs.getString("name")

						);
			}


		}catch (SQLException e) 
		{
			e.printStackTrace();
		}


		return null;
	}


}
