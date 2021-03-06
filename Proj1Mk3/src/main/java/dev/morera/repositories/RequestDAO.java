package dev.morera.repositories;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.morera.models.Grade;
import dev.morera.models.Request;
import dev.morera.models.Status;
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
				
				 Request rrr = new Request(req_id, requester,grade, grading_scheme,
						cost, passing_grade, datetime, location, description, justification, status, "");
				rrr.setValue(this.getPercent(rrr.getReq_id()));
				 
				return  rrr;
				
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
						cost, passing_grade, datetime, location, description, justification, status, "");
				
//				Request rrr = new Request(req_id, requester,grade, grading_scheme,
//						cost, passing_grade, datetime, location, description, justification, status);
				double perc =this.getPercent(re.getGrading_scheme());
				re.setValue(perc);
				System.out.println("req id" +req_id +"base cost: " +cost+"\npercent: "+perc+ "\nbase*perc:" + re.getValue());
				 
							
				
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
		
//		String sql = "select * from project1.requests order by req_id";
		String sql = "select * from project1.employees e, project1.requests r  where e.e_id = r.requester order by r.requester ,r.req_id";
		
		
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
				String name =rs.getString("name");
				
				Request re = new Request(req_id, requester,grade, grading_scheme,
						cost, passing_grade, datetime, location, description, justification, status,name);
				double perc =this.getPercent(re.getGrading_scheme());
				re.setValue(perc);
				System.out.println("base cost: " +cost+"\npercent: "+perc+ "\nbase*perc:" + re.getValue());
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
		 int x = ps.executeUpdate();
		 System.out.println(x);
			return (x==1);
			
		 }
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public Boolean changeStatus(Status s) {
		
		String sql = "update project1.requests set status = ? where req_id = ?";
		
		 try (Connection conn = cu.getConnection()){
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, s.getStatus());
				ps.setInt(2, s.getReq_id());
			 
				return (ps.executeUpdate()==1);
				
			 }
			catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
	public double getPercent(int t_id) {
		String sql = "select reimbursement_percent from project1.req_types where t_id = ?";
		
		 try (Connection conn = cu.getConnection()){
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, t_id);
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					System.out.println("ACTUAL RETURNED PERCENT:" + rs.getDouble("reimbursement_percent"));
					return rs.getDouble("reimbursement_percent");
					
				}
				
				
			 }
			catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		
	}
	
	
}
