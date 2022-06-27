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
//			public Request(int req_id, String requester, String manager, boolean is_done, double grade, int grading_scheme,
//					double cost, double passing_grade, LocalDateTime datetime, String location, String description,
//					String justification) {
//				super();
//				this.req_id = req_id;
//				this.requester = requester;
//				this.manager = manager;
//				this.is_done = is_done;
//				this.grade = grade;
//				this.grading_scheme = grading_scheme;
//				this.cost = cost;
//				this.passing_grade = passing_grade;
//				this.datetime = datetime;
//				this.location = location;
//				this.description = description;
//				this.justification = justification;
//			}			
			while (rs.next()) {
				//todo: change these ids to respcetive names
				int req_id = rs.getInt("req_id");
				int requester = rs.getInt("requester");
				int manager = rs.getInt("manager");
				boolean is_done = rs.getBoolean("is_done");
				double grade = rs.getDouble("grade");
				int grading_scheme = rs.getInt("grading_scheme");
				double cost = rs.getDouble("cost");
				double passing_grade = rs.getDouble("passing_grade");
				Timestamp datetime = rs.getTimestamp("datetime");
				String location = rs.getString("location");
				String description = rs.getString("description");
				String justification = rs.getString("justification");
				
				Request re = new Request(req_id, requester, manager, is_done, grade, grading_scheme,
						cost, passing_grade, datetime, location, description, justification);
				
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
}
