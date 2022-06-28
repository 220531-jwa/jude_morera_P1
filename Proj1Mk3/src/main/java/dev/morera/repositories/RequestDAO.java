package dev.morera.repositories;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import dev.morera.models.Request;
import dev.morera.utils.ConnectionUtility;

public class RequestDAO {

	//static?
	private   ConnectionUtility cu = ConnectionUtility.getConnectionUtility();
	
	public List<Request> getRequestsByUser(int id) {
		
		String sql = "select * from project1.requests where requester = ?";
		
		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			
			List<Request> reqs = new ArrayList<>();

//			}			
			while (rs.next()) {
				//todo: change these ids to respcetive names
				int req_id = rs.getInt("req_id");
				int requester = rs.getInt("requester");
//				int manager = rs.getInt("manager");
//				boolean is_done = rs.getBoolean("is_done");
				double grade = rs.getDouble("grade");
				int grading_scheme = rs.getInt("grading_scheme");
				double cost = rs.getDouble("cost");
				double passing_grade = rs.getDouble("passing_grade");
				Timestamp datetime = rs.getTimestamp("datetime");
				String location = rs.getString("location");
				String description = rs.getString("description");
				String justification = rs.getString("justification");
				int status = rs.getInt("status");
				
				Request re = new Request(req_id, requester,grade, grading_scheme,
						cost, passing_grade, datetime, location, description, justification, status);
				
				reqs.add(re);
			}
			for (Request r: reqs) {
				System.out.println(r);
			}
			return reqs;
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
		
	}

	public boolean createNewRequest(Request r) {
		
		//TODO: default passing_grade??
		String sql = "insert into project1.requests values( default, ? , 0, ?, ? , ? , ?, ? , ? , ? , default) returning *";
		
		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(r.getRequester()));
			ps.setInt(2, r.getGrading_scheme());
			ps.setDouble(3, r.getCost());
			ps.setDouble(4, r.getPassing_grade());
			ps.setTimestamp(5, r.getDatetime());
			ps.setString(6, r.getLocation());
			ps.setString(7, r.getDescription());
			ps.setString(8, r.getJustification());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
