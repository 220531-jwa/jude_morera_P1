package dev.morera.repositories;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.morera.models.Grade;
import dev.morera.models.Request;
import dev.morera.utils.ConnectionUtility;

public class RequestDAO {

	//static?
	private   ConnectionUtility cu = ConnectionUtility.getConnectionUtility();
	
	public Request getOneRequest(int inReq_id) {
		String sql = "select * from project1.requests where req_id = ?";
		
		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,inReq_id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int req_id = rs.getInt("req_id");
				int requester = rs.getInt("requester");

				double grade = rs.getDouble("grade");
				int grading_scheme = rs.getInt("grading_scheme");
				double cost = rs.getDouble("cost");
				double passing_grade = rs.getDouble("passing_grade");
				Timestamp datetime = rs.getTimestamp("datetime");
				String location = rs.getString("location");
				String description = rs.getString("description");
				String justification = rs.getString("justification");
				int status = rs.getInt("status");
				
				return new Request(req_id, requester,grade, grading_scheme,
						cost, passing_grade, datetime, location, description, justification, status);
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Request> getRequestsByUser(int id) {
		
		String sql = "select * from project1.requests where requester = ? order by req_id";
		
		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			
			List<Request> reqs = new ArrayList<>();
		
			while (rs.next()) {
				//todo: change these ids to respcetive names
				int req_id = rs.getInt("req_id");
				int requester = rs.getInt("requester");

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

	public List<Request> getAllRequests() {
		
		String sql = "select * from project1.requests order by req_id";
		
		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			List<Request> reqs = new ArrayList<>();

					
			while (rs.next()) {
				//todo: change these ids to respcetive names
				int req_id = rs.getInt("req_id");
				int requester = rs.getInt("requester");

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
			return reqs;
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public boolean gradeRequest(Grade g) {
		
		String sql = "update project1.requests set status = 3, grade = ? where req_id = ?";
		
		 try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, g.getGrade());
			ps.setInt(2, g.getReq_id());
		 
			return (ps.executeUpdate()==1);
			
		 }
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
