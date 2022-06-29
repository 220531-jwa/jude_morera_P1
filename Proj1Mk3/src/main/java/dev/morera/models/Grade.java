package dev.morera.models;

public class Grade {

	private int req_id;
	private double grade;
	
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Grade(int req_id, double grade) {
		super();
		this.req_id = req_id;
		this.grade = grade;
	}
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Grade [req_id=" + req_id + ", grade=" + grade + "]";
	}
	
	
}
