package dev.morera.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Request {

	private int req_id;
	private String requester;
	private String manager;
	private boolean is_done;
	private double grade;
	private int grading_scheme;
	private double cost;
	private double passing_grade;
	private Timestamp datetime; //not sure about this type
	private String location;
	private String description;
	private String justification;

	public Request() {
		super();
	}

	public Request(int req_id, String requester, String manager, boolean is_done, double grade, int grading_scheme,
			double cost, double passing_grade, Timestamp datetime, String location, String description,
			String justification) {
		super();
		this.req_id = req_id;
		this.requester = requester;
		this.manager = manager;
		this.is_done = is_done;
		this.grade = grade;
		this.grading_scheme = grading_scheme;
		this.cost = cost;
		this.passing_grade = passing_grade;
		this.datetime = datetime;
		this.location = location;
		this.description = description;
		this.justification = justification;
	}
	//bad constructor for testing
	public Request(int req_id, int requester, int manager, boolean is_done, double grade, int grading_scheme,
			double cost, double passing_grade, Timestamp datetime, String location, String description,
			String justification) {
		super();
		this.req_id = req_id;
		this.requester = Integer.toString(requester);
		this.manager = Integer.toString(manager);
		this.is_done = is_done;
		this.grade = grade;
		this.grading_scheme = grading_scheme;
		this.cost = cost;
		this.passing_grade = passing_grade;
		this.datetime = datetime;
		this.location = location;
		this.description = description;
		this.justification = justification;
	}
	

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public boolean isIs_done() {
		return is_done;
	}

	public void setIs_done(boolean is_done) {
		this.is_done = is_done;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getGrading_scheme() {
		return grading_scheme;
	}

	public void setGrading_scheme(int grading_scheme) {
		this.grading_scheme = grading_scheme;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPassing_grade() {
		return passing_grade;
	}

	public void setPassing_grade(double passing_grade) {
		this.passing_grade = passing_grade;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	

	

}
